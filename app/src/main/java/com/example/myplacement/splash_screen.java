

package com.example.myplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

public class splash_screen extends AppCompatActivity {

    private View logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Utils.blackIconStatusBar(splash_screen.this,R.color.white);

        logo=findViewById(R.id.logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash_screen.this,MainActivity.class);
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(splash_screen.this
                , Pair.create(logo,"logo"));
                startActivity(intent,options.toBundle());
            }
        },2500);
    }
}
