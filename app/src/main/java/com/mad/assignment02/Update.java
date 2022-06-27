package com.mad.assignment02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {


    EditText empFname, empLname, empAge, empPhone, empSalary, empPosition;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        this.setTitle("Update a Record");

        String[] pname = getIntent().getStringArrayExtra("Name");
        String pfname = pname[0];
        String plname = pname[1];

        empFname = findViewById(R.id.empFname);
        empLname = findViewById(R.id.empLname);
        empAge = findViewById(R.id.empAge);
        empPhone = findViewById(R.id.empPhone);
        empSalary = findViewById(R.id.empSalary);
        empPosition = findViewById(R.id.empPos);

        saveBtn = findViewById(R.id.updateBtn);

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
                    Employee emp = new Employee(fname, lname, Integer.parseInt(age),
                            Long.parseLong(phone), Integer.parseInt(salary), pos);


                    DBClass db = new DBClass(getBaseContext());
                    db.updateRecord(pfname, plname,emp);

                    Toast.makeText(getBaseContext(), "Record Successfully Updated",
                            Toast.LENGTH_LONG).show();

                    db.close();

                    startActivity(new Intent(Update.this, UpdateRecord.class));
                }
            }
        });
    }
}