package com.example.personality;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;
import com.agrawalsuneet.dotsloader.loaders.TashieLoader;

import static java.lang.Thread.sleep;

public class LoadActivity extends AppCompatActivity {

    LazyLoader lazyLoader;
    TextView load1;
    TextView load2;
    int total1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        Intent intent = getIntent();
        total1 = intent.getIntExtra("SUM",0);

        lazyLoader = findViewById(R.id.loader);
        load1 = findViewById(R.id.load1);
        load2 = findViewById(R.id.load2);

        LazyLoader loader = new LazyLoader(this, 30, 20, ContextCompat.getColor(this, R.color.loader_selected),
                ContextCompat.getColor(this, R.color.loader_selected),
                ContextCompat.getColor(this, R.color.loader_selected));
        loader.setAnimDuration(500);
        loader.setFirstDelayDuration(100);
        loader.setSecondDelayDuration(200);
        loader.setInterpolator(new LinearInterpolator());

        lazyLoader.addView(loader);

        //Typeface typeface = ResourcesCompat.getFont(this,R.font.blacklist);
        //load1.setTypeface(typeface);
        //load2.setTypeface(typeface);

        String s1 = "Analyzing your Answers,";
        String s2 = "Loading your Result...";

        load1.setText(s1);
        load2.setText(s2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(LoadActivity.this,ResultActivity.class);
                intent.putExtra("SUM", total1);
                startActivity(intent);
                LoadActivity.this.finish();

            }
        }).start();


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



    }
}
