package com.example.myplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudentLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        Utils.blackIconStatusBar(StudentLogin.this,R.color.white);
    }

    public void OnRegisterClicked(View view) {
        Intent register = new Intent(StudentLogin.this, Select.class);
        startActivity(register);
    }
}
