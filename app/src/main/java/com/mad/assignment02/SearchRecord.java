package com.mad.assignment02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchRecord extends AppCompatActivity {

    EditText etName;
    Button searchBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_record);

        this.setTitle("Search a Record");

        etName = (findViewById(R.id.searchName));
        searchBtn = findViewById(R.id.searchBtn);
        backBtn = findViewById(R.id.backBtnSearch);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();

                DBClass db = new DBClass(getBaseContext());
                Employee[] records = db.readAllRecords();

                Integer i = 0;
                Boolean isPresent = false;
                while(i < records.length){
                    if(name.equalsIgnoreCase(records[i].Fname) ||
                            name.equalsIgnoreCase("" + records[i].Fname + " " + records[i].Lname))
                    {
                        String txt = "\nFirst Name : " + records[i].Fname + "\nLast Name : " + records[i].Lname +
                                "\nAge : " + records[i].Age + "\nPhone : " + records[i].Phone +
                                "\nSalary : " + records[i].Salary + "\nPosition : " + records[i].Position;

                        AlertDialog.Builder builder = new AlertDialog.Builder(SearchRecord.this);
                        builder.setTitle("Record Found!");
                        builder.setMessage(txt);

                        builder.setNeutralButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();

//                        Toast.makeText(getBaseContext(), "Record Found!" + txt,
//                                Toast.LENGTH_LONG).show();
                        isPresent = true;
                        break;
                    }
                    i++;
                }

                if(!isPresent){
                    Toast.makeText(getBaseContext(), "Record Not Found!",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchRecord.this, MainActivity.class));
            }
        });
    }
}