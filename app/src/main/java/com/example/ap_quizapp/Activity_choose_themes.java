package com.example.ap_quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_choose_themes extends AppCompatActivity {
    class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.t1:
                    Intent intent = new Intent(getApplication(), Activity_question.class);
                    intent.putExtra("key","1");
                    startActivity(intent);
                    break;
                case R.id.t2:
                    Intent intent2 = new Intent(getApplication(), Activity_question.class);
                    intent2.putExtra("key","2");
                    startActivity(intent2);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_themes);

        Button button =(Button) findViewById(R.id.t1);
        button.setOnClickListener(new ButtonClickListener());

        Button button2 =(Button) findViewById(R.id.t2);
        button2.setOnClickListener(new ButtonClickListener());

        Button button3 =(Button) findViewById(R.id.t3);
        button3.setOnClickListener(new ButtonClickListener());

        Button button4 =(Button) findViewById(R.id.t4);
        button4.setOnClickListener(new ButtonClickListener());

        Button button5 =(Button) findViewById(R.id.t5);
        button5.setOnClickListener(new ButtonClickListener());

        Button button6 =(Button) findViewById(R.id.t6);
        button6.setOnClickListener(new ButtonClickListener());

        Button button7 =(Button) findViewById(R.id.t7);
        button7.setOnClickListener(new ButtonClickListener());

        Button button8 =(Button) findViewById(R.id.t8);
        button8.setOnClickListener(new ButtonClickListener());

        Button button9 =(Button) findViewById(R.id.t9);
        button9.setOnClickListener(new ButtonClickListener());

        Button button10 =(Button) findViewById(R.id.t10);
        button10.setOnClickListener(new ButtonClickListener());

        Button button11 =(Button) findViewById(R.id.t11);
        button11.setOnClickListener(new ButtonClickListener());
    }
}