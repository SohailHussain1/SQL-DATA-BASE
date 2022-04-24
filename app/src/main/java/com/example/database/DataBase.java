package com.example.database;

import static android.os.Build.ID;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.UserHandle;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {

    public static final String DataBase_Name="student.db";
    public static final String Table_Name="student_record";
    public static final String col_1="id";
    public static final String col_2="Name";
    public static final String col_3="Surname";
    public static final String col_4="Marks";
    public static final String col_5="Des";
    public static final String col_6="Mail";



    public DataBase(Context context ){
        super(context,DataBase_Name,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " +Table_Name + "(id INTEGER PRIMARY KEY ,"+"Name TEXT,Surname TEXT,Marks INTEGER,Des TEXT,Mail MAIL,Phno INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS " +Table_Name);
onCreate(db);
    }

    public boolean insertdata(String id2,String name,String Surname,String Marks,String Des,String Mail){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_1,id2);
        contentValues.put(col_2,name);
        contentValues.put(col_3,Surname);
        contentValues.put(col_4,Marks);
        contentValues.put(col_5,Des);
        contentValues.put(col_6,Mail);

        long result=db.insert(Table_Name,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }
    public boolean update(String id3,String name,String Surname,String Marks,String Des,String Mail)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_1,id3);
        contentValues.put(col_2,name);
        contentValues.put(col_3,Surname);
        contentValues.put(col_4,Marks);
        contentValues.put(col_5,Des);
        contentValues.put(col_6,Mail);
        db.update(Table_Name,contentValues,"id = ?",new String[]{id3});
        return true;
    }
    @SuppressLint("Range")
    public ArrayList <String> getUsers(){
        String[] li= {col_1,col_2,col_3,col_4,col_4,col_5};
        ArrayList<String> list= new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor=db.query(Table_Name,li,
                null,null,null,null,null);

        while(cursor.moveToNext()){
            list.add(cursor.getString(cursor.getColumnIndex(Table_Name)));
        }
        return list;
    }
    public Cursor show()
    {
        SQLiteDatabase db =this.getWritableDatabase();
Cursor res=db.rawQuery(" select * from "+Table_Name,null);
return res;
    }
}
