package com.example.myplacement.MyDbHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myplacement.Params.Params;
import com.example.myplacement.Users.Company;

public class CompanyDB extends SQLiteOpenHelper {

    public  CompanyDB (Context context) {
        super(context, Params.DB_NAME,null,Params.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.TABLE_NAME + "("
                + Params.KEY_COMPANY_ID + "INTEGER PRIMARY KEY," +
                Params.KEY_COMPANY_NAME + "TEXT," +
                Params.KEY_COMPANY_TM_NO + "TEXT," +
                Params.KEY_COMPANY_ADDRESS + "TEXT," +
                Params.KEY_COMPANY_EMAIL + "TEXT," +
                Params.KEY_COMPANY_PASS + "TEXT" + ")";
        db.execSQL(create);
    }

    public void addCompany(Company company){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Params.KEY_COMPANY_NAME,company.getName());
        cv.put(Params.KEY_COMPANY_TM_NO,company.getNo());
        cv.put(Params.KEY_COMPANY_ADDRESS,company.getAdd());
        cv.put(Params.KEY_COMPANY_EMAIL,company.getEmail());
        cv.put(Params.KEY_COMPANY_PASS,company.getPass());
        db.insert(Params.TABLE_NAME,null,cv);
        db.close();
    }

    public Boolean checkCompany(String username,String password){
        SQLiteDatabase db = getWritableDatabase();
        String[] colums = {Params.KEY_COMPANY_ID};
        String selection = Params.KEY_COMPANY_EMAIL + "=?" + " AND " + Params.KEY_COMPANY_PASS + "=?";
        String[] selectionArgs = {username,password};
        Cursor cursor = db.query(Params.TABLE_NAME,colums,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        if(count>0){
            return true;
        }
        return false;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
