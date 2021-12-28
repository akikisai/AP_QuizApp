package jp.sai.ap_quizapp;

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
    //クイズ何問目
    int quiz_num = 1;

    //ダイアログボックスタイトル
    String d_title;

    //テーマ質問解答を格納する

    String data_t9[][] = {
            {"XP", "eXtreme Programming", "開発手法や経験則をまとめたもの"},
            {"CMMI", "Capability Maturity Model Integration", "能力成熟度モデル統合"},
            {"SPA", "Software Process Assessment", "ソフトウエアプロセス評価"},
            {"DFD", "Data Flow Diagram", "データフローダイアグラム"},
            {"DOA", "Data Oriented Approach", "データ中心アプローチ"},
            {"UML", "Unified Modeling language", "モデリング言語の一つ"},
    };
    String data_t10[][] = {
            {"WBS", "Work Breakdown Structure", "作業を段階的に分解したもの"},
            {"PERT", "Program Evaluation and Review Technique", "作業の先行後続関係のアローダイアグラム表示"},
            {"PDM", "Precedence Diagramming Method", "プレシデンスダイアグラム法"},
            {"COCOMO", "　", "開発期間・開発工数を見積もる手法"},
            {"EVM", "Earned Value Management", "アーンドバリューマネジメント"},
            {"SLM", "Service Level Management", "サービスレベル管理"},
            {"SLA", "Service Level Agreement", "サービスレベル合意書"},
            {"RFC", "Request For Change", "変更要求"},
            {"BCP", "Business Continuity Plan", "事業継続管理"},
            {"ITIL", "Information Technology Infrastructure Library", "サービスマネジメントのフレームワーク"},
    };
    String data_t11[][] = {
            {"EA", " ", "エンタープライズアーキテクチャ"},
            {"EDM", "Evaluate Direct Monitor", "評価・指示・モニタ"},
            {"BPR", "Business Process Reengineering", "業務プロセス再設計・再構築"},
            {"BPM", "Business Process Management", "業務プロセス管理"},
            {"BPO", "Business Process Outsourcing", "社内業務を外部に委託する"},
            {"RPA", "Robotic Process Automation", "定型事務をAIやロボットで代替する"},
            {"SOA", "Service Oriented Architecture", "サービス指向アーキテクチャ"},
            {"CSF", "Critical Success Factors", "主要成功要因"},
            {"PPM", "Products Portfolio Management", "プロダクトポートフォリオマネジメント"},
            {"RFM", "Recency・Frequency・Monetary", "最新購買日・累計購買回数・累計購買金額"},
            {"CRM", "Customer Relationship Management", "顧客と密接関係を構築する"},
            {"SFA", "Sales Force Automation", "顧客満足度を向上する手法"},
            {"BSC", "Balance Score Card", "バランススコアカード"},
            {"JIT", "Just In Time", "中間在庫を減らすかんばん方式"},
    };

    //どのテーマのデータか
    String quiz_data[][] = {};

    //正解とは別の選択肢の答え
    ArrayList<String> data_list = new ArrayList<String>();

    //選択肢4つ
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

        for (int i = 0; i < data_t9.length; i++) {
            data_list.add(data_t9[i][2]);
        }
        for (int i = 0; i < data_t10.length; i++) {
            data_list.add(data_t10[i][2]);
        }
        for (int i = 0; i < data_t11.length; i++) {
            data_list.add(data_t11[i][2]);
        }

        //quiz_data 正解用
        if (num == 9)
            quiz_data = data_t9;
        else if (num == 10)
            quiz_data = data_t10;
        else if (num == 11)
            quiz_data = data_t11;

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
        correct_text = "正解数：" + String.valueOf(correct) + " / " + String.valueOf(quiz_data.length);
        tv2.setText(correct_text);

        Button btn1 = (Button) findViewById(R.id.q1);
        Button btn2 = (Button) findViewById(R.id.q2);
        Button btn3 = (Button) findViewById(R.id.q3);
        Button btn4 = (Button) findViewById(R.id.q4);

        btn1.setWidth(650);
        btn1.setHeight(220);

        btn2.setWidth(650);
        btn2.setHeight(220);

        btn3.setWidth(650);
        btn3.setHeight(220);

        btn4.setWidth(650);
        btn4.setHeight(220);

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

                        correct_text = "正解数：" + String.valueOf(correct) + " / " + String.valueOf(quiz_data.length);
                        tv2.setText(correct_text);

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


                                    int r1 = (int) (Math.random() * 4);
                                    int r2;
                                    for (int k = 0; k < 4; k++) {
                                        r2 = (int) (Math.random() * data_list.size());
                                        while(quiz_data[quiz_num - 1][2].equals(data_list.get(r2))){
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

                        correct_text = "正解数：" + String.valueOf(correct) + " / " + String.valueOf(quiz_data.length);
                        tv2.setText(correct_text);

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

                                    int r1 = (int) (Math.random() * 4);
                                    int r2;
                                    for (int k = 0; k < 4; k++) {
                                        r2 = (int) (Math.random() * data_list.size());
                                        while(quiz_data[quiz_num - 1][2].equals(data_list.get(r2))){
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

                        correct_text = "正解数：" + String.valueOf(correct) + " / " + String.valueOf(quiz_data.length);
                        tv2.setText(correct_text);

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

                                    int r1 = (int) (Math.random() * 4);
                                    int r2;
                                    for (int k = 0; k < 4; k++) {
                                        r2 = (int) (Math.random() * data_list.size());
                                        while(quiz_data[quiz_num - 1][2].equals(data_list.get(r2))){
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

                        correct_text = "正解数：" + String.valueOf(correct) + " / " + String.valueOf(quiz_data.length);
                        tv2.setText(correct_text);

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

                                    int r1 = (int) (Math.random() * 4);
                                    int r2;
                                    for (int k = 0; k < 4; k++) {
                                        r2 = (int) (Math.random() * data_list.size());
                                        while(quiz_data[quiz_num - 1][2].equals(data_list.get(r2))){
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