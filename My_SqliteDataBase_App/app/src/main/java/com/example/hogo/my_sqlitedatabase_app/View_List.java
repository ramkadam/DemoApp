package com.example.hogo.my_sqlitedatabase_app;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

import DataBase.database_helper;
import Modeal_Class.product__content;


public class View_List extends Activity {

    ListView list_TV;
    database_helper db;
    EditText Search_bar_ET;

    ArrayList<product__content> listProduct;

    private list_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__list);
        instilling();

        db = new database_helper(getApplicationContext());
        listProduct = new ArrayList<product__content>();
        listProduct = db.viewProduct();

        adapter = new list_Adapter(getApplicationContext(), R.layout.list_item, listProduct);
        list_TV.setAdapter(adapter);


        Search_bar_ET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                adapter.filter(Search_bar_ET.getText().toString().toLowerCase(Locale.getDefault()));

            }
        });


    }

    public void instilling() {
        list_TV = (ListView) findViewById(R.id.View_List_list_TV);
        Search_bar_ET = (EditText) findViewById(R.id.Search_bar_ET);
    }


}
