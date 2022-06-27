package com.mad.assignment02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertRecord extends AppCompatActivity {

    EditText empFname, empLname, empAge, empPhone, empSalary, empPosition;
    Button saveBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_record);

        this.setTitle("Insert New Record");

        empFname = findViewById(R.id.empFname);
        empLname = findViewById(R.id.empLname);
        empAge = findViewById(R.id.empAge);
        empPhone = findViewById(R.id.empPhone);
        empSalary = findViewById(R.id.empSalary);
        empPosition = findViewById(R.id.empPos);

        saveBtn = findViewById(R.id.saveBtn);
        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InsertRecord.this, MainActivity.class));
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = empFname.getText().toString();
                String lname = empLname.getText().toString();
                String age = empAge.getText().toString();
                String phone = empPhone.getText().toString();
                String salary = empSalary.getText().toString();
                String pos = empPosition.getText().toString();

                if(fname.equals("") || lname.equals("") || age.equals("") || age.equals("")
                    || salary.equals("") || pos.equals("")){
                    Toast.makeText(getBaseContext(), "All fields are Required!",
                            Toast.LENGTH_SHORT).show();
                }

                else{
                    DBClass db = new DBClass(getBaseContext());
                    db.insertRecord(fname, lname, Integer.parseInt(age),
                            Long.parseLong(phone), Integer.parseInt(salary), pos);

                    Toast.makeText(getBaseContext(), "Record Successfully Inserted",
                            Toast.LENGTH_LONG).show();

                    empFname.setText("");
                    empLname.setText("");
                    empAge.setText("");
                    empPhone.setText("");
                    empSalary.setText("");
                    empPosition.setText("");

                    db.close();
                }
            }
        });

    }
}