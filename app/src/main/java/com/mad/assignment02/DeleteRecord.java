package com.mad.assignment02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DeleteRecord extends AppCompatActivity {

    ListView lv;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_record);

        this.setTitle("Delete a Record");

        lv = findViewById(R.id.deleteLV);
        backBtn = findViewById(R.id.backBtnDel);

        DBClass db = new DBClass(getBaseContext());
        Employee[] records = db.readAllRecords();

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), records);
        lv.setAdapter(adapter);

        db.close();

        Toast.makeText(DeleteRecord.this, "Click on a record to delete",
                Toast.LENGTH_LONG).show();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] name = ((TextView)view.findViewById(R.id.tvName)).getText().toString().split(" ");

                AlertDialog.Builder builder = new AlertDialog.Builder(DeleteRecord.this);
                builder.setTitle("Delete Employee Record!");
                builder.setMessage("Are you sure you want to delete record of " +
                        name[0] + " " + name[1] + "?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.deleteRecord(name);
                        Toast.makeText(getBaseContext(), "Record Deleted Successfully!",
                                Toast.LENGTH_LONG).show();

                        startActivity(new Intent(DeleteRecord.this, MainActivity.class));
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Toast.makeText(getBaseContext(), "Deletion Aborted!",
                                Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeleteRecord.this, MainActivity.class));
            }
        });
    }
}