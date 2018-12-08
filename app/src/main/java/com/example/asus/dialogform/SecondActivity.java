package com.example.asus.dialogform;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    String name;
    String family;
    Integer age;
    Integer phone;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second);

        Intent returnIntent = new Intent();
        returnIntent.putExtra("RESULT","Information saved");

        setResult(Activity.RESULT_OK,returnIntent);

        Button button = findViewById(R.id.btnOk);

        TextView textViewName = findViewById(R.id.txtName);
        TextView textViewFamily = findViewById(R.id.txtFamily);
        TextView textViewAge = findViewById(R.id.txtAge);
        TextView textViewPhone = findViewById(R.id.txtPhone);
        TextView textViewEmail = findViewById(R.id.txtEmail);

        Intent intent = getIntent();

        name = intent.getStringExtra("key_name");
        family = intent.getStringExtra("key_family");
        age = intent.getIntExtra("key_age",0);
        phone = intent.getIntExtra("key_phone" , 0);
        email = intent.getStringExtra("key_email");

        textViewName.setText(name);
        textViewFamily.setText(family);
         textViewAge.setText(String.valueOf(age));
        textViewPhone.setText(String.valueOf(phone));
        textViewEmail.setText(email);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}


