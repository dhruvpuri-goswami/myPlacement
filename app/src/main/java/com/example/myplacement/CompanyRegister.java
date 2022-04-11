package com.example.myplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CompanyRegister extends AppCompatActivity {
    EditText no,name,add,email,pass,conpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_register);
        no = (EditText)findViewById(R.id.comp_tm_no);
        name = (EditText)findViewById(R.id.comp_name);
        add = (EditText)findViewById(R.id.comp_address);
        email = (EditText)findViewById(R.id.comp_email);
        pass = (EditText)findViewById(R.id.comp_pass);
        conpass = (EditText)findViewById(R.id.comp_con_pass);

    }

    public void OnRegisterClicked(View view) {

    }



    public void OnLoginClicked(View view) {
        Intent intent=new Intent(CompanyRegister.this,CompanyLogin.class);
        startActivity(intent);
    }
}
