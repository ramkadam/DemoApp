package com.example.hogo.my_sqlitedatabase_app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import Modeal_Class.product__content;


public class list_Adapter extends ArrayAdapter<product__content> {

    Context context;
    ArrayList<product__content> items;
    ArrayList<product__content> filter_Item;

    public list_Adapter(Context context, int resourceId, ArrayList<product__content> items) {
        super(context, resourceId, items);
        this.items = items;
        this.context = context;

        this.filter_Item=new ArrayList<product__content>();
        filter_Item.addAll(items);
    }

    private class ViewHolder {
        TextView txt_name;
        TextView txtDesc;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        convertView = mInflater.inflate(R.layout.list_item, null);
        holder = new ViewHolder();
        holder.txtDesc = (TextView) convertView.findViewById(R.id.list_item_description_TV);
        holder.txt_name = (TextView) convertView.findViewById(R.id.list_item_nmae_TV);
        convertView.setTag(holder);

        holder = (ViewHolder) convertView.getTag();
        holder.txtDesc.setText(items.get(position).getPro_description());
        holder.txt_name.setText(items.get(position).getPro_name());

        return convertView;
    }

       public void filter(String charText) {


        charText = charText.toLowerCase(Locale.getDefault());

        items.clear();
        if (charText.length() == 0)
        {
            items.addAll(filter_Item);
        } else {
            for (product__content wp : filter_Item) {

                if ((wp.getPro_name().toString().toLowerCase(Locale.getDefault()).contains(charText))|| (wp.getPro_description().toString().toLowerCase(Locale.getDefault()).contains(charText))) {
                    items.add(wp);
            }
            }
        }
        notifyDataSetChanged();
    }
}
