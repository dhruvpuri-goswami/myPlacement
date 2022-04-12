package com.example.myplacement.data;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.myplacement.AddJob;
import com.example.myplacement.CompanyLogin;
import com.example.myplacement.model.AddCompany;
import com.example.myplacement.model.Company;
import com.example.myplacement.params.Params;

import java.util.ArrayList;
import java.util.List;


public class MyDbHandler extends SQLiteOpenHelper {

    public MyDbHandler(Context context){
        super(context, Params.DB_NAME,null,Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.TABLE_NAME +"("
                + Params.JOB_ID + " INTEGER PRIMARY KEY, " +
                Params.JOB_NAME + " TEXT, " +
                Params.JOB_DESC + " TEXT, " +
                Params.JOB_SALARY + " TEXT " + ")";
        Log.d("db","Query being run is : " +create);
        db.execSQL(create);

        String company = "CREATE TABLE " + Params.TBL_COMPANY +"("
                + Params.COMPANY_ID + " INTEGER PRIMARY KEY, " +
                Params.COMPANY_NAME + " TEXT, " +
                Params.COMPANY_NO + " TEXT, " +
                Params.COMPANY_ADDRESS + " TEXT, " +
                Params.COMPANY_EMAIL + " TEXT, " +
                Params.COMPANY_PASS + " TEXT " + ")";
        Log.d("db","Query being run is : " +company);
        db.execSQL(company);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addJob(AddCompany addCompany){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Params.JOB_NAME, addCompany.getName());
        values.put(Params.JOB_DESC, addCompany.getDesc());
        values.put(Params.JOB_SALARY,addCompany.getSalary());
        db.insert(Params.TABLE_NAME,null,values);
        Log.d("addcompany","Job Created...");
        db.close();
    }

    public void addCompany(Company company){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Params.COMPANY_NAME, company.getName());
        values.put(Params.COMPANY_NO, company.getNo());
        values.put(Params.COMPANY_ADDRESS,company.getAddress());
        values.put(Params.COMPANY_EMAIL,company.getEmail());
        values.put(Params.COMPANY_PASS,company.getPass());
        db.insert(Params.TBL_COMPANY,null,values);
        Log.d("addcompany","Company Registered ...");
        db.close();
    }

    public void loginCompany(Company company){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from TBL_COMPANY",null,null);
        while (cursor.moveToNext()){
            String email=cursor.getString(4);
            String pass=cursor.getString(5);
            if(email.equals(company.getEmail()) && pass.equals(company.getPass())){
                Log.d("login","User Login Successfully...");
            }
        }
    }

    public List<AddCompany> getAllJobs(){
        List<AddCompany> itemsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor=db.rawQuery(select,null);

        if(cursor.moveToFirst()){
            do {
                AddCompany addCompany = new AddCompany();
                addCompany.setId(Integer.parseInt(cursor.getString(0)));
                addCompany.setName(cursor.getString(1));
                addCompany.setDesc(cursor.getString(2));
                addCompany.setSalary(cursor.getString(3));
                itemsList.add(addCompany);
            }while (cursor.moveToNext());
        }
        return itemsList;
    }

    public ArrayList getJobCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<String>();
        String select = "select (count(distinct name)) as cnt from " + Params.TABLE_NAME;
        Cursor cursor=db.rawQuery(select,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false) {
            if ((cursor != null) && (cursor.getCount() > 0)) {
                arrayList.add(cursor.getString(cursor.getColumnIndex("cnt")));
            }
            cursor.moveToNext();
        }
        return  arrayList;
    }




}
