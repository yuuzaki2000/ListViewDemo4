package com.example.listviewdemo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    static AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView showData = findViewById(R.id.showData);

        Button registerBtn = findViewById(R.id.registerBtn);
        db = AppDatabaseSingleton.getInstance(getApplicationContext());
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        // 本質的な処理
                        UserDao userDao = db.userDao();
                        EditText editName = findViewById(R.id.editName);
                        userDao.insert(new User(editName.getText().toString()));
                    }
                }).start();

                Snackbar.make(MainActivity.this,view,"1件のデータが登録されました。",Snackbar.LENGTH_LONG).show();

            }
        });

        Button displayBtn = findViewById(R.id.displayBtn);
        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });

    }

}