package com.speedoprogrammers.qeematbhakkar.AdaptersModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.speedoprogrammers.qeematbhakkar.R;

import java.util.ArrayList;

public class Adapter_qeemat extends BaseAdapter {

    Context c;
    ArrayList<qeemat_model> items;

    LayoutInflater inflater;
    boolean[] itemChecked;



    public Adapter_qeemat(Context c, ArrayList<qeemat_model> items) {
        this.c = c;
        this.items = items;
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemChecked= new boolean[items.size()];
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.fouritems_row,parent,false);
        }
        TextView srNo= (TextView) convertView.findViewById(R.id.srNo);
        TextView nameItem= (TextView) convertView.findViewById(R.id.nameItem);
        TextView price1= (TextView) convertView.findViewById(R.id.firstPrice);
        TextView price2= (TextView) convertView.findViewById(R.id.secondPrice);

        srNo.setText(items.get(position).getSrNo());
        nameItem.setText(items.get(position).getName());
        price1.setText(items.get(position).getPrice1());
        price2.setText(items.get(position).getPrice2());

        return convertView;
    }
}