package com.example.contentprovider;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.SharedElementCallback;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN";

    static DBHelper dbHelper;
    Button addButton;
    Button readButton;
    Button clearButton;
    static TextInputEditText name;
    static TextInputEditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        addButton = (Button)findViewById(R.id.addBtn);
        addButton.setOnClickListener(addBtn);

        readButton = (Button) findViewById(R.id.readBtn);
        readButton.setOnClickListener(readBtn);

        clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(clearBtn);

        name = (TextInputEditText) findViewById(R.id.name);
        email = (TextInputEditText) findViewById(R.id.email);


    }

    private static final View.OnClickListener clearBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            int clearCount = db.delete("mytable", null, null);
            Log.d(TAG, "Deleted: " + clearCount);

            dbHelper.close();
        }
    };

    private static final View.OnClickListener readBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            SQLiteDatabase db = dbHelper.getWritableDatabase();

            Log.d(TAG,"Rows in table");
            Cursor c = db.query("mytable", null, null, null, null, null, null);

            if (c.moveToFirst()){
                int idColIndex = c.getColumnIndex("id");
                int nameColIndex = c.getColumnIndex("name");
                int emailColIndex = c.getColumnIndex("email");

                do{
                    Log.d(TAG, "ID = "+ c.getInt(idColIndex)
                            + "\nName = " + c.getString(nameColIndex)
                            + "\nEmail = " + c.getString(emailColIndex)
                            + "\n=======");

                }while(c.moveToNext());
            }else{
                Log.d(TAG, "No data!");
            }
            c.close();
            dbHelper.close();
        }
    };

    private static final View.OnClickListener addBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ContentValues cv = new ContentValues();


            SQLiteDatabase db = dbHelper.getWritableDatabase();

            String mName = name.getText().toString();
            String mEmail = email.getText().toString();

            cv.put("name", mName);
            cv.put("email", mEmail);

            long rowID = db.insert("mytable", null, cv);
            Log.d(TAG, "Inserted: " + rowID);
            dbHelper.close();
        }
    };

}