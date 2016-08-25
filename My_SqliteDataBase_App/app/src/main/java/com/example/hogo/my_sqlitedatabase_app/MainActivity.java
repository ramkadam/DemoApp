package com.example.hogo.my_sqlitedatabase_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DataBase.database_helper;


public class MainActivity extends Activity {

    EditText name_ET, description_ET;
    Button add_BT, view_BT;
    String name_str, description_str;

    database_helper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instilling();

        db = new database_helper(getApplicationContext());

        add_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name_str = name_ET.getText().toString();
                description_str = description_ET.getText().toString();

                if ((!name_str.equals(null)) && (!description_str.equals(null))) {

                    boolean check = db.addProduct(name_str, description_str);

                    if (check == true) {

                        Toast.makeText(getApplicationContext(), " Product Add ", Toast.LENGTH_LONG).show();
                        name_ET.setText("");
                        description_ET.setText("");

                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Enter Product Details..", Toast.LENGTH_LONG).show();
                }
            }
        });

        view_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),View_List.class);
                startActivity(i);
            }
        });


    }


    public void instilling() {
        name_ET = (EditText) findViewById(R.id.MainActivity_name_ET);
        description_ET = (EditText) findViewById(R.id.MainActivity_description_ET);

        add_BT = (Button) findViewById(R.id.MainActivity_add_BT);
        view_BT = (Button) findViewById(R.id.MainActivity_view_BT);


    }
}
