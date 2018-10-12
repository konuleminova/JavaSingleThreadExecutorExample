package com.example.asus.javathreadpoolexample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.asus.javathreadpoolexample.R;
import com.example.asus.javathreadpoolexample.executorservice.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    List<String> imageList = new ArrayList<>();
    ImageView buttonNext, buttonBack;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageview);
        buttonNext = findViewById(R.id.button_next);
        buttonBack = findViewById(R.id.button_back);
        imageList.add("https://upload.wikimedia.org/wikipedia/commons/f/f9/Phoenicopterus_ruber_in_S%C3%A3o_Paulo_Zoo.jpg");
        imageList.add("https://www.gstatic.com/webp/gallery3/2_webp_ll.png");
        imageList.add("https://www.gstatic.com/webp/gallery3/1_webp_a.png");
        imageList.add("https://www.gstatic.com/webp/gallery3/3_webp_ll.png");
        imageList.add("https://www.gstatic.com/webp/gallery/4.jpg");
        imageList.add("https://www.gstatic.com/webp/gallery/5.jpg");
        imageList.add("https://www.gstatic.com/webp/gallery3/5.png");
        imageList.add("https://homepages.cae.wisc.edu/~ece533/images/airplane.png");
        imageList.add("https://upload.wikimedia.org/wikipedia/commons/f/f9/Phoenicopterus_ruber_in_S%C3%A3o_Paulo_Zoo.jpg");
        imageList.add("https://www.gstatic.com/webp/gallery3/2_webp_ll.png");
        imageList.add("https://www.gstatic.com/webp/gallery3/1_webp_a.png");
        imageList.add("https://www.gstatic.com/webp/gallery3/3_webp_ll.png");
        imageList.add("https://upload.wikimedia.org/wikipedia/commons/f/f9/Phoenicopterus_ruber_in_S%C3%A3o_Paulo_Zoo.jpg");
        imageList.add("https://www.gstatic.com/webp/gallery3/2_webp_ll.png");
        imageList.add("https://www.gstatic.com/webp/gallery3/1_webp_a.png");
        imageList.add("https://www.gstatic.com/webp/gallery3/3_webp_ll.png");
        imageList.add("https://upload.wikimedia.org/wikipedia/commons/f/f9/Phoenicopterus_ruber_in_S%C3%A3o_Paulo_Zoo.jpg");
        imageList.add("https://www.gstatic.com/webp/gallery3/2_webp_ll.png");
        imageList.add("https://www.gstatic.com/webp/gallery3/1_webp_a.png");
        imageList.add("https://www.gstatic.com/webp/gallery3/3_webp_ll.png");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < imageList.size(); i++) {
            executorService.execute(new Tasks(imageList.get(i)));
        }
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (i < Tasks.bitmapList.size()) {
                    imageView.setImageBitmap(Tasks.bitmapList.get(i));
                    i = i + 1;
                }
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    imageView.setImageBitmap(Tasks.bitmapList.get(i - 1));
                    i = i - 1;
                } catch (Exception e) {

                }
            }
        });


    }
}
