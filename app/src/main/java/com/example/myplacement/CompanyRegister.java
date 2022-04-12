package com.example.myplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myplacement.data.MyDbHandler;
import com.example.myplacement.model.Company;

public class CompanyRegister extends AppCompatActivity {
    EditText no,name,add,email,pass,conpass;
    MyDbHandler db =new MyDbHandler(CompanyRegister.this);

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
        Company company=new Company();
        company.setName(name.getText().toString());
        company.setNo(no.getText().toString());
        company.setAddress(add.getText().toString());
        company.setEmail(email.getText().toString());
        if(pass.getText().toString().equals(conpass.getText().toString())){
            company.setPass(pass.getText().toString());
            db.addCompany(company);
            Toast.makeText(getApplicationContext(),"Company Registered Successfully...",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CompanyRegister.this,CompanyLogin.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"Password Mismatch !!!",Toast.LENGTH_SHORT).show();
        }
    }



    public void OnLoginClicked(View view) {
        Intent intent=new Intent(CompanyRegister.this,CompanyLogin.class);
        startActivity(intent);
    }
}
