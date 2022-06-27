package com.mad.assignment02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button insertRecordBtn, displayRecordBtn, updateRecordBtn, delRecordBtn, searchRecordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("Employee SQLite Database");

        insertRecordBtn = findViewById(R.id.newRecordBtn);
        displayRecordBtn = findViewById(R.id.allRecordBtn);
        updateRecordBtn = findViewById(R.id.updateRecordBtn);
        delRecordBtn = findViewById(R.id.delRecordBtn);
        searchRecordBtn = findViewById(R.id.searchRecordBtn);

        insertRecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InsertRecord.class));
            }
        });

        displayRecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DisplayRecords.class));
            }
        });

        updateRecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UpdateRecord.class));
            }
        });

        delRecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DeleteRecord.class));
            }
        });

        searchRecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SearchRecord.class));

            }
        });
    }
}