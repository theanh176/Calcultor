package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class createSqlite extends AppCompatActivity {

    ProductOpenHelper productOpenHelper;
    EditText txtId;
    EditText txtName;
    EditText txtInstock;
    ListView lsProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sqlite);

        txtId = findViewById(R.id.txtId);
        txtName = findViewById(R.id.txtName);
        txtInstock = findViewById(R.id.txtInstock);
        lsProducts = findViewById(R.id.lsProducts);

        productOpenHelper = new ProductOpenHelper(this, "product.db", null, 1);
        SQLiteDatabase db = productOpenHelper.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS " + "ProductData(id INTEGER PRIMARY KEY DESC, Name TEXT, inStock INTEGER)");
    }

    public void onClick_ADD(View view){
        SQLiteDatabase db = productOpenHelper.getWritableDatabase();
        db.execSQL("INSERT INTO ProductData VALUES('" + txtId.getText().toString() + "','" + txtName.getText().toString() + "', '" + txtInstock.getText().toString() + "')");
        db.close();
    }

    public void onClick_ALL(View view) {
        ArrayAdapter adapter;
        adapter = new ArrayAdapter<ProductData>(this, android.R.layout.simple_list_item_1);
        SQLiteDatabase db = productOpenHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM ProductData", null);

        while ( (cursor.moveToNext())) {
            ProductData p = new ProductData(cursor.getString(0), cursor.getString(1), cursor.getInt(2));
            adapter.add(p);
        }
        lsProducts.setAdapter(adapter);
    }
}