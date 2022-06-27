package com.mad.assignment02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateRecord extends AppCompatActivity {

    ListView lv;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);

        lv = findViewById(R.id.updateLV);
        backBtn = findViewById(R.id.backBtnUpdate);

        DBClass db = new DBClass(getBaseContext());
        Employee[] records = db.readAllRecords();

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), records);
        lv.setAdapter(adapter);

        db.close();

        Toast.makeText(UpdateRecord.this, "Click on a record to update",
                Toast.LENGTH_LONG).show();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(UpdateRecord.this, Update.class);
                TextView nametv = view.findViewById(R.id.tvName);
                String[] name = nametv.getText().toString().split(" ");
                intent.putExtra("Name", name);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateRecord.this, MainActivity.class));
            }
        });
    }
}