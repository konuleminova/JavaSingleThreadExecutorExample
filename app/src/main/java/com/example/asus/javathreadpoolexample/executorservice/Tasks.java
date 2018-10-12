package com.example.asus.javathreadpoolexample.executorservice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Tasks implements Runnable {

    Bitmap myBitmap;
    static public List<Bitmap> bitmapList = new ArrayList<>();
    String string;

    public List<Bitmap> getBitmapList() {
        return bitmapList;
    }

    public Tasks(String string) {
        this.string = string;
    }

    public Tasks() {
    }

    @Override
    public void run() {

        Bitmap resultBitmap = null;
        try{
            URL url = new URL(string);
            URLConnection urlCon = url.openConnection();
            urlCon.connect();
            InputStream inputStream = urlCon.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] byteChunk = new byte[1024];
            int bytesRead = 0;
            while( (bytesRead = inputStream.read(byteChunk)) != -1) {
                byteArrayOutputStream.write(byteChunk, 0, bytesRead);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            BitmapFactory.Options bfOptions = new BitmapFactory.Options();
            bfOptions.inPurgeable = true;
            resultBitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, bfOptions);
            bitmapList.add(resultBitmap);
            byteArrayOutputStream.close();
            inputStream.close();
        }catch(MalformedURLException e) {
            Log.e("ERROR", "ERROR: " + e.toString());
            e.printStackTrace();
        }
        catch(IOException e) {
            Log.e("ERROR", "ERROR: " + e.toString());
            e.printStackTrace();
        }
    }
}
