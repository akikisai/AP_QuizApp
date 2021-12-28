package jp.sai.ap_quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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
            sentence = "グッド！ほかのテーマにも挑戦しましょう";
            tv1.setTextColor(Color.rgb(106, 134, 85));
        } else if (80 <= rate && rate < 90) {
            sentence = "よいできです！躓いた場所を復習しましょう";
            tv1.setTextColor(Color.rgb(106, 134, 85));
        } else if (70 <= rate && rate < 80) {
            sentence = "もっと点数を伸ばしましょう";
            tv1.setTextColor(Color.rgb(43, 115, 150));
        } else if (60 <= rate && rate < 70) {
            sentence = "もう一度チャレンジしましょう";
            tv1.setTextColor(Color.rgb(43, 115, 150));
        } else if (50 <= rate && rate < 60) {
            sentence = "おしい！このまま頑張りましょう";
            tv1.setTextColor(Color.rgb(134, 73, 68));
        } else if (40 <= rate && rate < 50) {
            sentence = "まずは6割を目指しましょう。";
            tv1.setTextColor(Color.rgb(134, 73, 68));
        } else if (30 <= rate && rate < 40) {
            sentence = "まだまだ伸びます！頑張りましょう";
            tv1.setTextColor(Color.rgb(134, 73, 68));
        } else if (20 <= rate && rate < 30) {
            sentence = "焦らずわからない場所をつぶしましょう";
            tv1.setTextColor(Color.rgb(134, 73, 68));
        } else if (10 <= rate && rate < 20) {
            sentence = "略語のアルファベットの意味を考えながら解きましょう";
            tv1.setTextColor(Color.rgb(134, 73, 68));
        } else if (0 <= rate && rate < 10) {
            sentence = "まず参考書を使って勉強しましょう";
            tv1.setTextColor(Color.rgb(134, 73, 68));
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

        findViewById(R.id.back).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplication(), MainActivity.class);
                        startActivity(intent);
                    }
                });

        Button btn1 =  (Button) findViewById(R.id.redo);
        Button btn2 =  (Button) findViewById(R.id.select_another);
        Button btn3 =  (Button) findViewById(R.id.back);

        // ボタンサイズの設定
        btn1.setWidth(500);
        btn1.setHeight(150);

        btn2.setWidth(500);
        btn2.setHeight(150);

        btn3.setWidth(500);
        btn3.setHeight(150);


    }
}