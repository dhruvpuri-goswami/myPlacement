package com.example.myplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.blackIconStatusBar(MainActivity.this,R.color.white);
    }

    public void OnRegisterClicked(View view) {
        Intent register = new Intent(MainActivity.this, Select.class);
        startActivity(register);
    }
}
