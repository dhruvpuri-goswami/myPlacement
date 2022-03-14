package com.example.myplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myplacement.MyDbHandler.CompanyDB;

public class CompanyLogin extends AppCompatActivity {
    CompanyDB c = new CompanyDB(CompanyLogin.this);
    EditText uname,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_login);
        uname=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);
    }

    public void OnRegisterClicked(View view) {
        Intent intent = new Intent(CompanyLogin.this,Register.class);
        startActivity(intent);
    }

    public void OnLoginClicked(View view) {
        String email = uname.getText().toString();
        String password = pass.getText().toString();
        if(email.equals("")||password.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please enter all fields",Toast.LENGTH_SHORT).show();
        }
        else {
            if(c.checkCompany(email,password)){
                Toast.makeText(getApplicationContext(),"Login Successfully...",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"Invalid details",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
