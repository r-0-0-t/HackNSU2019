package com.sust.nsu_project;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MyCourses extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton floatbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_courses);

        floatbtn = findViewById(R.id.floatbtn);
        floatbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.floatbtn){
            Intent intent = new Intent(MyCourses.this,AddCourse.class);
            startActivity(intent);
        }
    }
}
