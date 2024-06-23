package com.example.a3rdseassionsqlite_database;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowData extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    TextView textShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        //EdgeToEdge.enable(this);
        textShow = findViewById(R.id.textShow);
        databaseHelper = new DatabaseHelper(ShowData.this);

        Cursor cursor = databaseHelper.getAllData();
        textShow.setText(" Total Data "+cursor.getCount());


        if (cursor!=null && cursor.getCount()>0){
            while (cursor.moveToNext()){
                int id = cursor.getInt(0);
                String Name = cursor.getString(1);
                String Mobile = cursor.getString(2);
                textShow.append("\n ID:"+id+"\n Name:"+Name+"\n Mobile:"+Mobile);

            }

        }else {

            textShow.setText("Data Not Found");
        }








    }
}