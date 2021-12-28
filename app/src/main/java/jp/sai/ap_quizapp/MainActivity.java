package jp.sai.ap_quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Activity_choose_themes.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("アプリについて");
                builder.setMessage("応用情報技術者において略語の意味が覚えずらい！という人向けの略語問題アプリ。略語のもとからなる英語を確認しながら満点を目指しましょう。");


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });

        Button btn1 =  (Button) findViewById(R.id.btn_start);
        Button btn2 =  (Button) findViewById(R.id.btn_about);
        // ボタンサイズの設定
        btn1.setWidth(600);
        btn1.setHeight(200);

        btn2.setWidth(600);
        btn2.setHeight(200);


    }
}