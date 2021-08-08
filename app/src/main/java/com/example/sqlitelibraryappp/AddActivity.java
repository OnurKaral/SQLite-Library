package com.example.sqlitelibraryappp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class AddActivity extends AppCompatActivity {

    EditText title,author,pages;
    MaterialButton add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        title = findViewById(R.id.registertitle);
        author = findViewById(R.id.registerauthor);
        pages = findViewById(R.id.registerpages);

        add_button = findViewById(R.id.buttonRegister);

        add_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                DatabaseHelper DBHelper = new DatabaseHelper(AddActivity.this);
                DBHelper.addBook(title.getText().toString().trim(),
                        author.getText().toString().trim(),
                        Integer.valueOf(pages.getText().toString().trim()));



            }
        });









    }
}