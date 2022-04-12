package com.example.myplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myplacement.data.MyDbHandler;
import com.example.myplacement.model.Company;

public class CompanyLogin extends AppCompatActivity {
    EditText uname,pass;
    MyDbHandler db =new MyDbHandler(CompanyLogin.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_login);
        uname=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);
    }

    public void OnRegisterClicked(View view) {
        Intent intent = new Intent(CompanyLogin.this, CompanyRegister.class);
        startActivity(intent);
    }

    public void OnLoginClicked(View view) {
        String email = uname.getText().toString();
        String psw = pass.getText().toString();
        if(email.equals("lnt@gmail.com") && psw.equals("lnt")){
            Intent intent = new Intent(CompanyLogin.this,CompanyDashboard.class);
            startActivity(intent);
        }
    }
}
