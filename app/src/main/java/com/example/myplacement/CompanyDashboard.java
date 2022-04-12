package com.example.myplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myplacement.data.MyDbHandler;
import com.example.myplacement.model.AddCompany;

import java.util.ArrayList;
import java.util.List;

public class CompanyDashboard extends AppCompatActivity {
    ArrayList<String> arrayList=new ArrayList<String>();

    MyDbHandler db =new MyDbHandler(CompanyDashboard.this);

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_dashboard);
        lv = findViewById(R.id.lv);
        getAllItems();
    }

    public void OnAddJobClicked(View view) {
        Intent intent = new Intent(CompanyDashboard.this,AddJob.class);
        startActivity(intent);
    }

    public void getAllItems(){
        List<AddCompany> allUsers = null;
        allUsers = db.getAllJobs();
        for(AddCompany items :allUsers) {
            String name = items.getName();
            arrayList.add(name);
        }
        ArrayAdapter<String> adt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adt);
    }

    public void onLogoutClicked(View view) {
        Intent intent = new Intent(CompanyDashboard.this,CompanyLogin.class);
        startActivity(intent);
    }
}
