package com.example.jain.localdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onButtonClick(View v) {
        EditText id = (EditText) findViewById(R.id.editTextEmpId);
        EditText name = (EditText) findViewById(R.id.editTextEmpName);
        EditText addr = (EditText) findViewById(R.id.editTextEmpAddr);
        EditText sal = (EditText) findViewById(R.id.editTextEmpSal);
        TextView total = (TextView) findViewById(R.id.textViewTotalRecords);

        Employee emp = new Employee();
        emp.empId = Integer.parseInt(id.getText().toString());
        emp.empName = name.getText().toString();
        emp.empAddr = addr.getText().toString();
        emp.empSal = Integer.parseInt(sal.getText().toString());

        myDatabase database = new myDatabase(this);
        database.saveData(emp);
        int cnt = database.empCount();
        total.setText("Total Records Saved= " + cnt);

        id.setText("");
        name.setText("");
        addr.setText("");
        sal.setText("");

    }

    public void onButtonClick1(View v) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }
}

