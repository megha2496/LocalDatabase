package com.example.jain.localdatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Jain on 6/13/2017.
 */

public class myDatabase extends SQLiteOpenHelper {

    public myDatabase(Context context) {
        super(context, "myDB", null, 1);

    }

    public void onCreate(SQLiteDatabase db) {
        String query = "create table employee ( empid INTEGER, empnam TEXT, empadd TEXT, empsal INTEGER)";
        db.execSQL(query);
    }

    public void saveData(Employee e) {
        String query = "Insert into employee values (" + e.empId + ", '" + e.empName + "', '" + e.empAddr + "', " + e.empSal + " )";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
    }

    public int empCount() {
        String query = "select * from employee";
        SQLiteDatabase db = getReadableDatabase();
        Cursor x = db.rawQuery(query, null);
        int count = x.getCount();
        return count;
    }


    public ArrayList<Employee> showEmp() {
        ArrayList<Employee> data = new ArrayList<>();


        String qry = " select * from employee";
        SQLiteDatabase db = getReadableDatabase();
        Cursor x = db.rawQuery(qry, null);
        // x.moveToLast();

        while (x.moveToNext()) {
            Employee employee = new Employee();
            employee.empId = x.getInt(0);
            employee.empName = x.getString(1);
            employee.empAddr = x.getString(2);
            employee.empSal = x.getInt(3);

            data.add(employee);
        }

        return data;
    }


    public void deleteEmp(int empcode){
        String qry=" delete from employee where empid="+empcode;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(qry);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
