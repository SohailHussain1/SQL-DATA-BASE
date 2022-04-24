package com.example.database;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class adapter extends ArrayAdapter {

    List list=new ArrayList();

    public adapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    static class layout{
        TextView id,name,surname,marks,dec,email;
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        layout ly;
        if(row==null){
            LayoutInflater lay= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ly=new layout();
            row=lay.inflate(R.layout.activity_listview,parent,false);
            ly.id=(TextView)row.findViewById(R.id.t1);
            ly.name=(TextView)row.findViewById(R.id.t2);
            ly.surname=(TextView)row.findViewById(R.id.t3);
            ly.marks=(TextView)row.findViewById(R.id.t4);
            ly.dec=(TextView)row.findViewById(R.id.t5);
            ly.email=(TextView)row.findViewById(R.id.t6);

            row.setTag(ly);
        }
        else{
            ly=(layout)row.getTag();
        }

        data da=(data) this.getItem(position);
        ly.id.setText(da.getId());
        ly.name.setText(da.getName());
        ly.surname.setText(da.getSurname());
        ly.marks.setText(da.getMarks());
        ly.dec.setText(da.getDec());
        ly.email.setText(da.getEmail());


        return row;
    }
}

