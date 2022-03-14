package com.example.myplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myplacement.MyDbHandler.CompanyDB;
import com.example.myplacement.Users.Company;

public class Register extends AppCompatActivity {
    EditText no,name,add,email,pass,conpass;

    CompanyDB c = new CompanyDB(Register.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        no = (EditText)findViewById(R.id.comp_tm_no);
        name = (EditText)findViewById(R.id.comp_name);
        add = (EditText)findViewById(R.id.comp_address);
        email = (EditText)findViewById(R.id.comp_email);
        pass = (EditText)findViewById(R.id.comp_pass);
        conpass = (EditText)findViewById(R.id.comp_con_pass);

    }

    public void OnRegisterClicked(View view) {
        String tm_no = no.getText().toString();
        String c_name = name.getText().toString();
        String c_add = add.getText().toString();
        String c_pass = pass.getText().toString();
        String c_email = email.getText().toString();
        String c_conpass = conpass.getText().toString();

        if(tm_no.isEmpty() && c_add.isEmpty() && c_name.isEmpty() && c_email.isEmpty()
                && c_pass.isEmpty() && c_conpass.isEmpty()){
            Toast.makeText(getApplicationContext(),"All Fields are Manditary !!!",Toast.LENGTH_SHORT).show();
        }
        else {
            if(c_pass.equals(c_conpass)){
                addcompany();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Password must be same !!!",Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void addcompany(){
        String tm_no = no.getText().toString();
        String c_name = name.getText().toString();
        String c_add = add.getText().toString();
        String c_pass = pass.getText().toString();
        String c_email = email.getText().toString();

        Company company = new Company();
        company.setName(c_name);
        company.setAdd(c_add);
        company.setNo(tm_no);
        company.setEmail(c_email);
        company.setPass(c_pass);
        c.addCompany(company);
        Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
    }
}
