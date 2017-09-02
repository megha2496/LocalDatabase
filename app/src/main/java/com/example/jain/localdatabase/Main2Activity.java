package com.example.jain.localdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        myDatabase obj=new myDatabase(this);
        ArrayList<Employee> data= obj.showEmp();

        myBaseAdapter adapter=new myBaseAdapter(this,data);
        ListView listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }
}
