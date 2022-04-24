package com.example.database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {

    DataBase my;
    EditText name, surname, marks, mail, dec, id;
    Button add, view, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my = new DataBase(this);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.Surname);
        marks = findViewById(R.id.Marks);
        dec = findViewById(R.id.des);
        mail = findViewById(R.id.mail);
        id = findViewById(R.id.id);
        add = findViewById(R.id.button1);
        view = findViewById(R.id.button2);
        btnUpdate = findViewById(R.id.button3);
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String id1 = id.getText().toString();

                        if (TextUtils.isEmpty(id1)) {
                            Toast.makeText(MainActivity.this, "Plase enter ID which you want to update", Toast.LENGTH_LONG).show();
                            return;
                        }
                        boolean isUpdate = my.update(id.getText().toString(), name.getText().toString(),
                                surname.getText().toString(),
                                marks.getText().toString(),
                                dec.getText().toString(),
                                mail.getText().toString());
                        if (isUpdate == true) {
                            Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_LONG).show();
                            name.setText("");
                            surname.setText("");
                            marks.setText("");
                            dec.setText("");
                            mail.setText("");

                        } else {
                            Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );


    }


    public void onclick(View view) {
        boolean inserted = my.insertdata(id.getText().toString(), name.getText().toString(), surname.getText().toString(), marks.getText().toString(), dec.getText().toString(), mail.getText().toString());
        if (inserted == true)
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Error not inserted", Toast.LENGTH_SHORT).show();
    }

    public void k(View view) {
        Intent i= new Intent(getApplicationContext(),listview.class);
        startActivity(i);
    }
}
