package com.example.personality;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView text;
    TextView note;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        total = intent.getIntExtra("SUM",0);

        text = (TextView) findViewById(R.id.total);
        note = findViewById(R.id.note);

        //Typeface typeface = ResourcesCompat.getFont(this,R.font.blacklist);
        //text.setTypeface(typeface);


        //String st=String.valueOf(total);
        //text.setText(st);
        String a = "The thing you secretly dream about is fame and recognition. You want people to know and admire you.";
        String b = "Your hidden desire is to love and be loved. In other words, you need a person to feel connected to.";
        String c = "Your deepest wish is to be rich and successful. Money embodies the luxury and comfort you've always wanted.";
        String d = "You want nothing more than some peace and quiet. Sometimes you feel ready to leave everything you know and head for a calm and tranquil place where nobody knows you.";
        String e = "NOTE : The results are based on some research, and does not define anything about anyone.";

        note.setText(e);

        if(total >= 100 && total <= 170)
        {
            text.setText(a);
        }
        else if(total >= 180 && total <= 250)
        {
            text.setText(b);
        }
        else if(total >= 260 && total <= 330)
        {
            text.setText(c);
        }
        else if(total >= 340 && total <= 400)
        {
            text.setText(d);
        }

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.myamin);
        text.setAnimation(anim);
        note.setAnimation(anim);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
}
