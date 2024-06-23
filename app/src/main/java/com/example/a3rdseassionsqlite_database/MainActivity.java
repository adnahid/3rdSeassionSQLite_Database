package com.example.a3rdseassionsqlite_database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button insertBtn,showBtn;
    EditText edname,edphone;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        insertBtn = findViewById(R.id.insertBtn);
        showBtn = findViewById(R.id.showBtn);
        edname = findViewById(R.id.edname);
        edphone = findViewById(R.id.edphone);
        dbHelper = new DatabaseHelper(MainActivity.this);



        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edname.length()>0 && edphone.length()>0){
                    dbHelper.insertData(edname.getText().toString(), edphone.getText().toString());
                    Toast.makeText(MainActivity.this, "Data Inserted properly", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this, "Data Not Inserted ", Toast.LENGTH_SHORT).show();
            }
        });


        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ShowData.class);
                startActivity(intent);
            }
        });


    }
}