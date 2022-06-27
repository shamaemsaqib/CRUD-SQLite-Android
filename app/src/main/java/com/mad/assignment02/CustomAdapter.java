package com.mad.assignment02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    public Context context;
    public Employee[] data;
    public LayoutInflater inflater;

    public CustomAdapter(Context context, Employee[] records){
        this.context = context;
        this.data = records;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.my_list_view, null);

        TextView tvName, tvAge, tvPhone, tvSalary, tvPosition;
        tvName = view.findViewById(R.id.tvName);
        tvAge = view.findViewById(R.id.tvAge);
        tvPhone = view.findViewById(R.id.tvPhone);
        tvSalary = view.findViewById(R.id.tvSalary);
        tvPosition = view.findViewById(R.id.tvPosition);

        tvName.setText("" + data[i].Fname + " " + data[i].Lname);
        tvAge.setText("" + data[i].Age);
        tvPhone.setText("" + data[i].Phone);
        tvSalary.setText("" + data[i].Salary);
        tvPosition.setText("" + data[i].Position);

        return view;
    }
}
