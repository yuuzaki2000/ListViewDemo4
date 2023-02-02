package com.example.listviewdemo4;

import static com.example.listviewdemo4.MainActivity.db;
import static com.example.listviewdemo4.MainActivity.db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        new Thread(new Runnable(){

            @Override
            public void run() {
                // 本質的な処理
                UserDao userDao = db.userDao();
                List<User> atList = userDao.getAll();
                ArrayList<String> arrayList = new ArrayList<>();
                for(User user:atList){
                    arrayList.add(user.getName());
                }

                ListView secondView = findViewById(R.id.secondView);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(SecondActivity.this,android.R.layout.simple_list_item_1,arrayList);

                secondView.setAdapter(arrayAdapter);

            }
        }).start();

        ListView secondView = findViewById(R.id.secondView);
        secondView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });


    }
}