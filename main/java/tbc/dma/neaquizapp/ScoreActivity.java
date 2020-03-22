package tbc.dma.neaquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView totalObtainedScoreTextView;
    private TextView q1;
    private TextView q2;
    private TextView q3;
    private TextView q4;
    private TextView q5;
    private TextView q6;
    private TextView q7;
    private TextView q8;
    private TextView q9;
    private TextView q10;
    private Button shareResultButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        shareResultButton = findViewById(R.id.share_result_button);
        shareResultButton.setOnClickListener(this);
//layout instances
        totalObtainedScoreTextView = findViewById(R.id.score_circle_text);
        q1 =  findViewById(R.id.your_ans_one);
        q2 =  findViewById(R.id.your_ans_two);
        q3 =  findViewById(R.id.your_ans_three);
        q4 =  findViewById(R.id.your_ans_four);
        q5 =  findViewById(R.id.your_ans_five);
        q6 =  findViewById(R.id.your_ans_six);
        q7 =  findViewById(R.id.your_ans_seven);
        q8 =  findViewById(R.id.your_ans_eight);
        q9 =  findViewById(R.id.your_ans_nine);
        q10 =  findViewById(R.id.your_ans_ten);

        Intent i = getIntent();
        ArrayList<String> yourAnswers = (ArrayList<String>) getIntent().getSerializableExtra("yourAnswers");
        q1.setText(yourAnswers.get(0));
        q2.setText(yourAnswers.get(1));
        q3.setText(yourAnswers.get(2));
        q4.setText(yourAnswers.get(3));
        q5.setText(yourAnswers.get(4));
        q6.setText(yourAnswers.get(5));
        q7.setText(yourAnswers.get(6));
        q8.setText(yourAnswers.get(7));
        q9.setText(yourAnswers.get(8));
        q10.setText(yourAnswers.get(9));

        String totalScore = i.getStringExtra("scoreKey");
        totalScore = totalScore + '/'+ "100";
        totalObtainedScoreTextView.setText(totalScore);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.share_result_button){
            Intent i = new Intent(Intent.ACTION_VIEW);
            startActivity(i);
        }
    }
}
