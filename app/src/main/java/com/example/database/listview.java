package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class listview extends AppCompatActivity {
    ListView list;
    DataBase db;
    SQLiteDatabase sql;
    Cursor cu;
    adapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        list=findViewById(R.id.list);
        db=new DataBase(this);
        sql=db.getReadableDatabase();
        cu=db.show();
        adapt=new adapter(getApplicationContext(),R.layout.activity_listview);
        list.setAdapter(adapt);
        if(cu.moveToFirst())
        {
            do{
                String id,name,surname,email,marks,dec,skill;
                id=cu.getString(0);
                name=cu.getString(1);
                surname=cu.getString(2);
                marks=cu.getString(3);
                dec=cu.getString(4);
                email=cu.getString(5);
                data da=new data(id,name,surname,marks,dec,email);
                adapt.add(da);

            }while(cu.moveToNext());
        }

    }
}