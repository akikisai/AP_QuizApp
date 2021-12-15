package com.example.ap_quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity_question extends AppCompatActivity {
    //クイズ何問目なのか
    int quiz_num = 1;

    //ダイアログボックスタイトル
    String d_title;

    //テーマ質問解答を格納する
    String data_t1[][] = {
            {"BCM", "BajhsaCjsMajs", "ビーシーエム"},
            {"222", "2222", "22222"},
            {"333", "3333", "33333"},
            {"444", "4444", "44444"},
            {"555", "5555", "55555"},
    };

    String data_t2[][] = {
            {"qq", "qw", "qe"},
            {"as", "ad", "af"},
            {"zx", "zc", "zv"},
            {"rt", "ry", "ru"},
            {"rg", "rh", "rj"},
    };

    //quiz_data 正解用
    String quiz_data[][] = {};

    //正解とは別の選択肢の答えを格納するdata_list
    ArrayList<String> data_list = new ArrayList<String>();

    //乱数用
    ArrayList<Integer> random = new ArrayList<Integer>();
    int c = -1;

    //解答用
    String[] ans = new String[4];

    //質問文
    String quiz_text;

    //正解数
    String correct_text;
    int correct = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        //渡されるkeyの値
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        int num = Integer.parseInt(extra.getString("key"));


        //正解とは別の選択肢の答えを格納するdata_list
        for (int i = 0; i < data_t1.length; i++) {
            data_list.add(data_t1[i][2]);
        }
        for (int i = 0; i < data_t2.length; i++) {
            data_list.add(data_t2[i][2]);
        }

        //quiz_data 正解用
        if (num == 1)
            quiz_data = data_t1;
        else if (num == 2)
            quiz_data = data_t2;

        //解答用
        int r1 = (int) (Math.random() * 4);
        int r2;
        for (int k = 0; k < 4; k++) {
            r2 = (int) (Math.random() * data_list.size());
            while(quiz_data[0][2].equals(data_list.get(r2))){
                r2 = (int) (Math.random() * data_list.size());
            }
            ans[k] = data_list.get(r2);
        }
        ans[r1] = quiz_data[0][2];


        //最初のクイズ設定
        TextView tv1 = (TextView) findViewById(R.id.quiz_text);
        quiz_text = "Q" + quiz_num + ":" + quiz_data[0][0] + "とは？";
        tv1.setText(quiz_text);

        TextView tv2 = (TextView) findViewById(R.id.correct_counter);
        correct_text = "正解数：" + String.valueOf(correct);
        tv2.setText(correct_text);

        Button btn1 = (Button) findViewById(R.id.q1);
        Button btn2 = (Button) findViewById(R.id.q2);
        Button btn3 = (Button) findViewById(R.id.q3);
        Button btn4 = (Button) findViewById(R.id.q4);

        btn1.setText(ans[0]);
        btn2.setText(ans[1]);
        btn3.setText(ans[2]);
        btn4.setText(ans[3]);


        findViewById(R.id.q1).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btn1 = (Button) findViewById(R.id.q1);
                        if (btn1.getText().equals(quiz_data[quiz_num - 1][2])) {
                            d_title = "正解だよ!";
                            correct++;
                        } else d_title = "不正解";
                        AlertDialog.Builder builder = new AlertDialog.Builder(Activity_question.this);
                        builder.setTitle(d_title);
                        builder.setMessage(quiz_data[quiz_num - 1][0] + "\n" +
                                quiz_data[quiz_num - 1][1] + "\n" +
                                quiz_data[quiz_num - 1][2]);

                        builder.setPositiveButton("次へ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                quiz_num++;
                                if (quiz_num <= quiz_data.length) {

                                    quiz_text = "Q" + quiz_num + ":" + quiz_data[quiz_num - 1][0] + "とは？";
                                    tv1.setText(quiz_text);
                                    correct_text = "正解数：" + String.valueOf(correct);
                                    tv2.setText(correct_text);

                                    int r1 = (int) (Math.random() * 4);
                                    int r2;
                                    for (int k = 0; k < 4; k++) {
                                        r2 = (int) (Math.random() * data_list.size());
                                        while(quiz_data[0][2].equals(data_list.get(r2))){
                                            r2 = (int) (Math.random() * data_list.size());
                                        }
                                        ans[k] = data_list.get(r2);
                                    }
                                    ans[r1] = quiz_data[quiz_num - 1][2];

                                    btn1.setText(ans[0]);
                                    btn2.setText(ans[1]);
                                    btn3.setText(ans[2]);
                                    btn4.setText(ans[3]);
                                } else {
                                    Intent intent = new Intent(getApplication(), Activity_finish.class);
                                    intent.putExtra("key_correct", String.valueOf(correct));
                                    intent.putExtra("key_quiz_num", String.valueOf(quiz_data.length));
                                    intent.putExtra("key_num", String.valueOf(num));
                                    startActivity(intent);
                                }
                            }
                        });
                        builder.show();


                    }
                });

        findViewById(R.id.q2).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btn2 = (Button) findViewById(R.id.q2);
                        if (btn2.getText().equals(quiz_data[quiz_num - 1][2])) {
                            d_title = "正解だよ!";
                            correct++;
                        } else d_title = "不正解";
                        AlertDialog.Builder builder = new AlertDialog.Builder(Activity_question.this);
                        builder.setTitle(d_title);
                        builder.setMessage(quiz_data[quiz_num - 1][0] + "\n" +
                                quiz_data[quiz_num - 1][1] + "\n" +
                                quiz_data[quiz_num - 1][2]);

                        builder.setPositiveButton("次へ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                quiz_num++;
                                if (quiz_num <= quiz_data.length) {

                                    quiz_text = "Q" + quiz_num + ":" + quiz_data[quiz_num - 1][0] + "とは？";
                                    tv1.setText(quiz_text);
                                    correct_text = "正解数：" + String.valueOf(correct);
                                    tv2.setText(correct_text);

                                    int r1 = (int) (Math.random() * 4);
                                    int r2;
                                    for (int k = 0; k < 4; k++) {
                                        r2 = (int) (Math.random() * data_list.size());
                                        while(quiz_data[0][2].equals(data_list.get(r2))){
                                            r2 = (int) (Math.random() * data_list.size());
                                        }
                                        ans[k] = data_list.get(r2);
                                    }
                                    ans[r1] = quiz_data[quiz_num - 1][2];
                                    btn1.setText(ans[0]);
                                    btn2.setText(ans[1]);
                                    btn3.setText(ans[2]);
                                    btn4.setText(ans[3]);
                                } else {
                                    Intent intent = new Intent(getApplication(), Activity_finish.class);
                                    intent.putExtra("key_correct", String.valueOf(correct));
                                    intent.putExtra("key_quiz_num", String.valueOf(quiz_data.length));
                                    intent.putExtra("key_num", String.valueOf(num));
                                    startActivity(intent);
                                }
                            }
                        });
                        builder.show();


                    }
                });

        findViewById(R.id.q3).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btn3 = (Button) findViewById(R.id.q3);
                        if (btn3.getText().equals(quiz_data[quiz_num - 1][2])) {
                            d_title = "正解だよ!";
                            correct++;
                        } else d_title = "不正解";
                        AlertDialog.Builder builder = new AlertDialog.Builder(Activity_question.this);
                        builder.setTitle(d_title);
                        builder.setMessage(quiz_data[quiz_num - 1][0] + "\n" +
                                quiz_data[quiz_num - 1][1] + "\n" +
                                quiz_data[quiz_num - 1][2]);

                        builder.setPositiveButton("次へ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                quiz_num++;
                                if (quiz_num <= quiz_data.length) {

                                    quiz_text = "Q" + quiz_num + ":" + quiz_data[quiz_num - 1][0] + "とは？";
                                    tv1.setText(quiz_text);
                                    correct_text = "正解数：" + String.valueOf(correct);
                                    tv2.setText(correct_text);

                                    int r1 = (int) (Math.random() * 4);
                                    int r2;
                                    for (int k = 0; k < 4; k++) {
                                        r2 = (int) (Math.random() * data_list.size());
                                        while(quiz_data[0][2].equals(data_list.get(r2))){
                                            r2 = (int) (Math.random() * data_list.size());
                                        }
                                        ans[k] = data_list.get(r2);
                                    }
                                    ans[r1] = quiz_data[quiz_num - 1][2];
                                    btn1.setText(ans[0]);
                                    btn2.setText(ans[1]);
                                    btn3.setText(ans[2]);
                                    btn4.setText(ans[3]);
                                } else {
                                    Intent intent = new Intent(getApplication(), Activity_finish.class);
                                    intent.putExtra("key_correct", String.valueOf(correct));
                                    intent.putExtra("key_quiz_num", String.valueOf(quiz_data.length));
                                    intent.putExtra("key_num", String.valueOf(num));
                                    startActivity(intent);
                                }
                            }
                        });
                        builder.show();

                    }
                });

        findViewById(R.id.q4).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btn4 = (Button) findViewById(R.id.q4);
                        if (btn4.getText().equals(quiz_data[quiz_num - 1][2])) {
                            d_title = "正解だよ!";
                            correct++;
                        } else d_title = "不正解";
                        AlertDialog.Builder builder = new AlertDialog.Builder(Activity_question.this);
                        builder.setTitle(d_title);
                        builder.setMessage(quiz_data[quiz_num - 1][0] + "\n" +
                                quiz_data[quiz_num - 1][1] + "\n" +
                                quiz_data[quiz_num - 1][2]);

                        builder.setPositiveButton("次へ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                quiz_num++;
                                if (quiz_num <= quiz_data.length) {

                                    quiz_text = "Q" + quiz_num + ":" + quiz_data[quiz_num - 1][0] + "とは？";
                                    tv1.setText(quiz_text);
                                    correct_text = "正解数：" + String.valueOf(correct);
                                    tv2.setText(correct_text);

                                    int r1 = (int) (Math.random() * 4);
                                    int r2;
                                    for (int k = 0; k < 4; k++) {
                                        r2 = (int) (Math.random() * data_list.size());
                                        while(quiz_data[0][2].equals(data_list.get(r2))){
                                            r2 = (int) (Math.random() * data_list.size());
                                        }
                                        ans[k] = data_list.get(r2);
                                    }
                                    ans[r1] = quiz_data[quiz_num - 1][2];
                                    btn1.setText(ans[0]);
                                    btn2.setText(ans[1]);
                                    btn3.setText(ans[2]);
                                    btn4.setText(ans[3]);
                                } else {
                                    Intent intent = new Intent(getApplication(), Activity_finish.class);
                                    intent.putExtra("key_correct", String.valueOf(correct));
                                    intent.putExtra("key_quiz_num", String.valueOf(quiz_data.length));
                                    intent.putExtra("key_num", String.valueOf(num));
                                    startActivity(intent);
                                }
                            }
                        });
                        builder.show();

                    }
                });


    }
}