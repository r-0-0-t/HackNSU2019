package com.sust.nsu_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Course extends AppCompatActivity {

    private TextView tv;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Course");
        setContentView(R.layout.activity_course);
        tv = findViewById(R.id.reg);
    }

    public void onRegClick(View view) {
        tv.setVisibility(View.VISIBLE);
    }
}
