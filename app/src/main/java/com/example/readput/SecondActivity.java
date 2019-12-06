package com.example.readput;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondlayout);
        FileInputStream in = null;
        BufferedReader read = null;
        StringBuilder temp = new StringBuilder();
        String tt = null;
        try {
            in = openFileInput("data");
            read = new BufferedReader(new InputStreamReader(in));
            while ((tt = read.readLine()) != null) {
                System.out.println(tt);
                temp.append(tt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                read.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TextView textView = findViewById(R.id.second_show);
        textView.setText(temp);
    }
}