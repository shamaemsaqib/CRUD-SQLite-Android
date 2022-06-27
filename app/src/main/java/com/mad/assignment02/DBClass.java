package com.mad.assignment02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.dynamicanimation.animation.SpringAnimation;

import java.math.BigInteger;
import java.net.Inet4Address;

public class DBClass extends SQLiteOpenHelper {

    Context view;
    public static final String DB_NAME = "EmployeeDB";
    DBClass(Context context){
        super(context, DB_NAME, null, 1);
        view = context;
    }

    public void insertRecord(String fname, String lname, Integer age, Long phone,
                             Integer salary, String position){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues emp = new ContentValues();
        emp.put("fname", fname);
        emp.put("lname", lname);
        emp.put("age", age);
        emp.put("phone", phone);
        emp.put("salary", salary);
        emp.put("position", position);

        db.insert("record", null, emp);
        db.close();
    }

    public Employee[] readAllRecords(){
        SQLiteDatabase read = getReadableDatabase();
        Cursor cursor = read.rawQuery("SELECT * FROM record", null);
        int size = cursor.getCount();
        Employee[] records = new Employee[size];

        cursor.moveToFirst();
        int i = 0;
        while(!cursor.isAfterLast()){
            String fname = cursor.getString(1);
            String lname = cursor.getString(2);
            Integer age = cursor.getInt(3);
            Long phone = cursor.getLong(4);
            Integer salary = cursor.getInt(5);
            String pos = cursor.getString(6);

            records[i] = new Employee(fname, lname, age, phone, salary, pos);
            i++;

            cursor.moveToNext();
        }

        return records;
    }

    public void updateRecord(String pfname, String plname, Employee employee){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues emp = new ContentValues();
        emp.put("fname", employee.Fname);
        emp.put("lname", employee.Lname);
        emp.put("age", employee.Age);
        emp.put("phone", employee.Phone);
        emp.put("salary", employee.Salary);
        emp.put("position", employee.Position);

        db.update("record", emp, "fname = ? AND lname = ?", new String[]{pfname, plname});
        db.close();
    }

    public void deleteRecord(String[] name){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("record", "fname = ? AND lname = ?", new String[]{name[0],name[1]});
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table record(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "fname VARCHAR(30) NOT NULL, " +
                "lname VARCHAR(30) NOT NULL, " +
                "age INTEGER NOT NULL, " +
                "phone BIGINT NOT NULL, " +
                "salary INTEGER NOT NULL, " +
                "position VARCHAR(30));";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE record");
        onCreate(sqLiteDatabase);
    }
}
