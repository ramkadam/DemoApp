package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import Modeal_Class.product__content;

public class database_helper extends SQLiteOpenHelper {

    private static String dataBase_Name = "Sqlite";
    private static int dataBase_version = 1;
    private static String table_Name = "product";
    private static String product_ID = "product_id";
    private static String product_Name = "product_name";
    private static String product_Description = "product_description";


    public database_helper(Context context) {
        super(context, dataBase_Name, null, dataBase_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "create table " + table_Name + "(" + product_ID + " integer primary key, " + product_Name + " text," + product_Description + " text)";
        db.execSQL(query);
    }

    public boolean addProduct(String product_name, String product_description) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(product_Name, product_name);
        contentValues.put(product_Description, product_description);
        db.insert(table_Name, null, contentValues);
        return true;
    }


    public ArrayList<product__content> viewProduct() {

        ArrayList<product__content> product_value = new ArrayList<product__content>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("select * from " + table_Name + "", null);
        res.moveToFirst();

        for (int i = 0; i < res.getCount(); i++) {

            product__content set_product = new product__content();

            set_product.setPro_name(res.getString(res.getColumnIndex(product_Name)));
            set_product.setPro_description(res.getString(res.getColumnIndex(product_Description)));
            product_value.add(set_product);

            res.moveToNext();
        }

        return product_value;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
