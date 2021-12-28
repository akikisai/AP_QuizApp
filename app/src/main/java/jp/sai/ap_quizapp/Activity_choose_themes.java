package jp.sai.ap_quizapp;

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
                case R.id.t9:
                    Intent intent9 = new Intent(getApplication(), Activity_question.class);
                    intent9.putExtra("key","9");
                    startActivity(intent9);
                    break;
                case R.id.t10:
                    Intent intent10 = new Intent(getApplication(), Activity_question.class);
                    intent10.putExtra("key","10");
                    startActivity(intent10);
                    break;
                case R.id.t11:
                    Intent intent11 = new Intent(getApplication(), Activity_question.class);
                    intent11.putExtra("key","11");
                    startActivity(intent11);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_themes);

        Button button9 =(Button) findViewById(R.id.t9);
        button9.setOnClickListener(new ButtonClickListener());
        button9.setWidth(500);
        button9.setHeight(180);

        Button button10 =(Button) findViewById(R.id.t10);
        button10.setOnClickListener(new ButtonClickListener());
        button10.setWidth(500);
        button10.setHeight(180);

        Button button11 =(Button) findViewById(R.id.t11);
        button11.setOnClickListener(new ButtonClickListener());
        button11.setWidth(500);
        button11.setHeight(180);




    }
}