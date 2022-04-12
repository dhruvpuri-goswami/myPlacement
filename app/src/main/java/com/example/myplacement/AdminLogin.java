package com.example.myplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    EditText uname,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        uname=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);
    }

    public void OnLoginClicked(View view) {
        String tpo = uname.getText().toString();
        String psw = pass.getText().toString();
        if(tpo.equals("721") && psw.equals("umangshukla")){
            Toast.makeText(getApplicationContext(),"Login Successfully...",Toast.LENGTH_SHORT).show();

            Intent register = new Intent(AdminLogin.this, AdminDashboard.class);
            startActivity(register);

        }
        else {
            Toast.makeText(getApplicationContext(),"Please enter valid fields !..",Toast.LENGTH_SHORT).show();
        }
    }
}
