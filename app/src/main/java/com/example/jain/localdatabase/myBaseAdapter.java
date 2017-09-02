package com.example.jain.localdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jain on 6/19/2017.
 */

public class myBaseAdapter extends BaseAdapter {

    Context ctx;
    ArrayList<Employee> data;

    myBaseAdapter(Context context, ArrayList<Employee> emps){
        ctx=context;
        data=emps;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.my_view,null);

        TextView tvName=(TextView) v.findViewById(R.id.textViewName);
        TextView tvAdrr=(TextView) v.findViewById(R.id.textViewAddress);
        Button button=(Button) v.findViewById(R.id.buttonDelete);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabase obj=new myDatabase(ctx);
                obj.deleteEmp(data.get(position).empId);
                data.remove(position);
                notifyDataSetChanged();

            }
        });

        Employee emp1=data.get(position);
        tvName.setText(emp1.empName);
        tvAdrr.setText(emp1.empAddr);

        return v;
    }
}
