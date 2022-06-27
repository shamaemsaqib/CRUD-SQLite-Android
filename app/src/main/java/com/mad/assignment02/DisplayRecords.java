package com.mad.assignment02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class DisplayRecords extends AppCompatActivity {

    ListView lv;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_records);

        this.setTitle("Display All Records");

        lv = findViewById(R.id.allRecordLV);
        backBtn = findViewById(R.id.backBtnDisplay);

        DBClass db = new DBClass(getBaseContext());
        Employee[] records = db.readAllRecords();

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), records);
        lv.setAdapter(adapter);

        Toast.makeText(this, "Found " + records.length + " Records!",
                Toast.LENGTH_SHORT).show();

        db.close();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DisplayRecords.this, MainActivity.class));
            }
        });
    }
}