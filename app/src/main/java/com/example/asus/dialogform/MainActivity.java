package com.example.asus.dialogform;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

String name;
String family;
Integer age;
Integer phone;
String email;

    EditText editTextName;
    EditText editTextFamily;
    EditText editTextAge;
    EditText editTextPhone;
    EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonExit = findViewById(R.id.btnExit);
        Button buttonSave = findViewById(R.id.btn);

        editTextName = findViewById(R.id.edtName);
        editTextFamily = findViewById(R.id.edtFamily);
        editTextAge = findViewById(R.id.edtAge);
        editTextPhone = findViewById(R.id.edtPhone);
        editTextEmail = findViewById(R.id.edtEmail);


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                name=editTextName.getText().toString();
                family = editTextFamily.getText().toString();
                age = Integer.parseInt(editTextAge.getText().toString());
                phone = Integer.parseInt(editTextPhone.getText().toString());
                email = editTextEmail.getText().toString();

                intent.putExtra("key_name",name);
                intent.putExtra("key_family",family);
                intent.putExtra("key_age",age);
                intent.putExtra("key_phone",phone);
                intent.putExtra("key_email",email );

                startActivityForResult(intent,150);
            }
        });



        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setMessage("Do you want to exit?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==150){
            if(resultCode==Activity.RESULT_OK){
                String result = data.getStringExtra("RESULT");

                Toast.makeText(MainActivity.this,result ,Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("pre_key_name",name).apply();
        PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("pre_key_family",family).apply();
        PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putInt("pre_key_age",age).apply();
        PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putInt("pre_key_phone",phone).apply();
        PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("pre_key_email",email).apply();
    }


    @Override
    protected void onResume() {
        super.onResume();

        String name =PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("pre_key_name",null);
        editTextName.setText(name);

        String family =PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("pre_key_family",null);
        editTextFamily.setText(family);

        Integer age =PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getInt("pre_key_age",0);
        editTextAge.setText(String.valueOf(age));

        Integer phone =PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getInt("pre_key_phone",0);
        editTextPhone.setText(String.valueOf(phone));

        String email =PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("pre_key_email",null);
        editTextEmail.setText(email);

    }


}
