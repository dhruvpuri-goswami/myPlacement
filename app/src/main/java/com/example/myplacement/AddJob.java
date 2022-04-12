package com.example.myplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myplacement.data.MyDbHandler;
import com.example.myplacement.model.AddCompany;

public class AddJob extends AppCompatActivity {

    MyDbHandler db =new MyDbHandler(AddJob.this);
    EditText name,desc,salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);
        name=findViewById(R.id.job_name);
        desc=findViewById(R.id.job_desc);
        salary=findViewById(R.id.job_salary);
    }

    public void OnAddJobClicked(View view) {
        AddCompany addCompany = new AddCompany();
        addCompany.setName(name.getText().toString());
        addCompany.setDesc(desc.getText().toString());
        addCompany.setSalary(salary.getText().toString());
        db.addJob(addCompany);
        Toast.makeText(getApplicationContext(),"Job Added Successfully",Toast.LENGTH_SHORT).show();
    }
}
