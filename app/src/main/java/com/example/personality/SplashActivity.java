package com.example.personality;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private TextView appName;
    private TextView des1;
    private TextView des2;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        appName = findViewById(R.id.appName);
        des1 = findViewById(R.id.des1);
        des2 = findViewById(R.id.des2);
        startButton = findViewById(R.id.startButton);

        //Typeface typeface = ResourcesCompat.getFont(this,R.font.blacklist);
        //appName.setTypeface(typeface);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.myamin);
        appName.setAnimation(anim);
        des1.setAnimation(anim);
        des2.setAnimation(anim);
        startButton.setAnimation(anim);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
}
