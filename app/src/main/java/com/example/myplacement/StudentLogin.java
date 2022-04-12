package com.example.myplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StudentLogin extends AppCompatActivity {
    EditText uname,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        uname=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);
        Utils.blackIconStatusBar(StudentLogin.this,R.color.white);
    }

    public void OnRegisterClicked(View view) {
        Intent register = new Intent(StudentLogin.this, Select.class);
        startActivity(register);
    }

    public void OnLoginClicked(View view) {
        String email = uname.getText().toString();
        String psw = pass.getText().toString();
        if(email.equals("goswami@gmail.com") && psw.equals("dhruv")){
            Toast.makeText(getApplicationContext(),"Login Successfully...",Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(getApplicationContext(),"Please enter valid fields !..",Toast.LENGTH_SHORT).show();
        }
    }
}
