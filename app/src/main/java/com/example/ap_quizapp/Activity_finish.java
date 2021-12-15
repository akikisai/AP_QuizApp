package com.example.ap_quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_finish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        //渡されるkeyの値
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        int correct = Integer.parseInt(extra.getString("key_correct"));

        Bundle extra2 = intent.getExtras();
        int quiz_num = Integer.parseInt(extra2.getString("key_quiz_num"));

        Bundle extra3 = intent.getExtras();
        int num = Integer.parseInt(extra3.getString("key_num"));

        int rate = correct * 100 / quiz_num;
        String rate_text = "";
        String sentence = "";

        TextView tv1 = (TextView) findViewById(R.id.rate);
        rate_text = String.valueOf(rate) + "%";
        tv1.setText(rate_text);

        TextView tv2 = (TextView) findViewById(R.id.sentence);
        if (90 <= rate && rate <= 100) {
            sentence = "完璧です！ほかのテーマにも挑戦しましょう";
        } else if (80 <= rate && rate < 90) {
            sentence = "よいできです！躓いた場所を復習しましょう";
        } else if (70 <= rate && rate < 80) {
            sentence = "もっと点数を伸ばしましょう";
        } else if (60 <= rate && rate < 70) {
            sentence = "もう一度チャレンジしましょう";
        } else if (50 <= rate && rate < 60) {
            sentence = "おしい！このまま頑張りましょう";
        } else if (40 <= rate && rate < 50) {
            sentence = "まずは6割を目指しましょう。";
        } else if (30 <= rate && rate < 40) {
            sentence = "まだまだ伸びます！頑張りましょう";
        } else if (20 <= rate && rate < 30) {
            sentence = "焦らずわからない場所をつぶしましょう";
        } else if (10 <= rate && rate < 20) {
            sentence = "略語のアルファベットの意味を考えながら解きましょう";
        } else if (0 <= rate && rate < 10) {
            sentence = "まず参考書を使って勉強しましょう";
        }
        tv2.setText(sentence);

        findViewById(R.id.redo).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplication(), Activity_question.class);
                        intent.putExtra("key", String.valueOf(num));
                        startActivity(intent);
                    }
                });

        findViewById(R.id.select_another).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplication(), Activity_choose_themes.class);
                        startActivity(intent);
                    }
                });


    }
}