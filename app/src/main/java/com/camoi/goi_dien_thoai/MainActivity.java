package com.camoi.goi_dien_thoai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText number;
    private TextView textViewContact;
    private ImageButton call;
    private ImageButton contacts;
   // static int PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        number = (EditText) findViewById(R.id.et_number);
        call = (ImageButton) findViewById(R.id.call);
        contacts = (ImageButton) findViewById(R.id.contacts);
        textViewContact = (TextView) findViewById(R.id.tv_contact);

       /* if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_CODE);
        }
*/
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonenumber = number.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+phonenumber));
                startActivity(intent);
            }
        });


        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getPackageManager().getLaunchIntentForPackage("com.camoi.contacts");
                startActivity(i);
            }
        });


    }

    @NonNull
    private ArrayList<Contact> getContacts() {
        Cursor cursor = getContentResolver().query(Contract.ContactEntry.CONTENT_URI,
                null,
                null,
                null,
                Contract.ContactEntry.COLUMN_NAME);
        ArrayList<Contact> returnList =new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
//                int contactID = cursor.getInt(0);
                String contactName = cursor.getString(1);
                String contactPhone = cursor.getString(2);
                Contact contact = new Contact(contactName, contactPhone);
                returnList.add(contact);
            } while(cursor.moveToNext());
        }
        else {
            //failure. do not add any thing to the list
        }
        cursor.close();
        return returnList;
    }
}