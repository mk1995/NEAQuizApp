package tbc.dma.neaquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    private Button submit;
    private static final int TotalScore = 100;
    private int TotalObtainedScore;
    private int TotalMistakeScore;

    private RadioButton ansOneRadioButton;
    private RadioButton yourAnsOneRadioButton;
    private RadioGroup ansOneRadioGroup;

    private RadioButton ansTwoRadioButton;
    private RadioButton yourAnsTwoRadioButton;
    private RadioGroup ansTwoRadioGroup;

    private RadioButton ansThreeRadioButton;
    private RadioButton yourAnsThreeRadioButton;
    private RadioGroup ansThreeRadioGroup;

    private CheckBox ansFourCheckBox;
    private CheckBox ansFourOneCheckBox;
    private CheckBox ansFourTwoCheckBox;
    private CheckBox ansFourFourCheckBox;

    private RadioButton ansFiveRadioButton;
    private RadioButton yourAnsFiveRadioButton;
    private RadioGroup ansFiveRadioGroup;

    private EditText ansSixEditText;

    private RadioButton ansSevenRadioButton;
    private RadioButton yourAnsSevenRadioButton;
    private RadioGroup ansSevenRadioGroup;

    private CheckBox ansEightCheckBox;
    private CheckBox ansEightOneCheckBox;
    private CheckBox ansEightTwoCheckBox;
    private CheckBox ansEightFourCheckBox;

    private RadioButton ansNineRadioButton;
    private RadioButton yourAnsNineRadioButton;
    private RadioGroup ansNineRadioGroup;

    private RadioButton ansTenRadioButton;
    private RadioButton yourAnsTenRadioButton;
    private RadioGroup ansTenRadioGroup;

    private ArrayList yourAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

//        layout instances
        ansOneRadioButton = findViewById(R.id.ans_one_three);
        ansOneRadioGroup = (RadioGroup) findViewById(R.id.ans_one_radio_group);

        ansTwoRadioButton = findViewById(R.id.ans_two_two);
        ansTwoRadioGroup = (RadioGroup) findViewById(R.id.ans_two_radio_group);

        ansThreeRadioButton = findViewById(R.id.ans_three_two);
        ansThreeRadioGroup = (RadioGroup) findViewById(R.id.ans_three_radio_group);

        ansFourCheckBox = findViewById(R.id.ans_four_three);
        ansFourFourCheckBox = findViewById(R.id.ans_four_four);
        ansFourOneCheckBox = findViewById(R.id.ans_four_one);
        ansFourTwoCheckBox = findViewById(R.id.ans_four_two);

        ansFiveRadioButton = findViewById(R.id.ans_five_three);
        ansFiveRadioGroup = (RadioGroup) findViewById(R.id.ans_five_radio_group);

        ansSixEditText = findViewById(R.id.ans_six_editText);

        ansSevenRadioButton = findViewById(R.id.ans_seven_two);
        ansSevenRadioGroup = (RadioGroup) findViewById(R.id.ans_seven_radio_group);

        ansEightCheckBox = findViewById(R.id.ans_eight_three);
        ansEightFourCheckBox = findViewById(R.id.ans_eight_four);
        ansEightOneCheckBox = findViewById(R.id.ans_eight_one);
        ansEightTwoCheckBox = findViewById(R.id.ans_eight_two);

        ansNineRadioButton = findViewById(R.id.ans_nine_two);
        ansNineRadioGroup = (RadioGroup) findViewById(R.id.ans_nine_radio_group);

        ansTenRadioButton = findViewById(R.id.ans_ten_two);
        ansTenRadioGroup = (RadioGroup) findViewById(R.id.ans_ten_radio_group);

        submit = findViewById(R.id.submit_button);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.submit_button:
                TotalObtainedScore = 0;
                yourAnswers = new ArrayList(9);

                yourAnsOneRadioButton = findViewById(ansOneRadioGroup.getCheckedRadioButtonId());
                yourAnsTwoRadioButton = findViewById(ansTwoRadioGroup.getCheckedRadioButtonId());
                yourAnsThreeRadioButton = findViewById(ansThreeRadioGroup.getCheckedRadioButtonId());
                yourAnsFiveRadioButton = findViewById(ansFiveRadioGroup.getCheckedRadioButtonId());
                yourAnsSevenRadioButton = findViewById(ansSevenRadioGroup.getCheckedRadioButtonId());
                yourAnsNineRadioButton = findViewById(ansNineRadioGroup.getCheckedRadioButtonId());
                yourAnsTenRadioButton = findViewById(ansTenRadioGroup.getCheckedRadioButtonId());

                //Toast.makeText(this, "Evaluating Your Result.....", Toast.LENGTH_SHORT).show();
                if(ansOneRadioButton.isChecked()) {
                    TotalObtainedScore += 10;
                    String q1 = "Q1: " + yourAnsOneRadioButton.getText().toString().trim();
                    yourAnswers.add(0, q1);
                }
                else{
                    if(yourAnsOneRadioButton != null){
                        String q1 = "Q1: " + yourAnsOneRadioButton.getText();
                        yourAnswers.add(0, q1);
                    }else{
                        yourAnswers.add(0, "Q1: Not Selected");
                    }
                }
                if (ansTwoRadioButton.isChecked()) {
                    TotalObtainedScore += 10;
                    String q2 = "Q2: " + yourAnsTwoRadioButton.getText().toString().trim();
                    yourAnswers.add(1, q2);
                }
                else{
                    if(yourAnsTwoRadioButton != null){
                        String q2 = "Q2: " + yourAnsTwoRadioButton.getText().toString().trim();
                        yourAnswers.add(1, q2);
                    }else{
                        yourAnswers.add(1, "Q2: Not selected");
                    }
                }
                if(ansThreeRadioButton.isChecked()){
                    TotalObtainedScore += 10;
                    String q3 = "Q3: " + yourAnsThreeRadioButton.getText().toString().trim();
                    yourAnswers.add(2, q3);
                }
                else{
                    if(yourAnsThreeRadioButton != null) {
                        String q3 = "Q3: " + yourAnsThreeRadioButton.getText().toString().trim();
                        yourAnswers.add(2, q3);
                    }else{
                        yourAnswers.add(2, "Q3: Not selected");
                    }
                }

                if (ansFourCheckBox.isChecked() && !ansFourFourCheckBox.isChecked() && !ansFourTwoCheckBox.isChecked() && !ansFourOneCheckBox.isChecked()){
                    TotalObtainedScore += 10;
                    String q4 = "Q4: " + ansFourCheckBox.getText().toString().trim();
                    yourAnswers.add(3, q4);
                }
                else{
                    String q4;
                    if(ansFourFourCheckBox.isChecked()){
                        q4 = "Q4: " + ansFourFourCheckBox.getText().toString().trim();
                        yourAnswers.add(3, q4);
                    }
                    else if(ansFourTwoCheckBox.isChecked()){
                        q4 = "Q4: " + ansFourTwoCheckBox.getText().toString().trim();
                        yourAnswers.add(3, q4);
                    }
                    else if(ansFourOneCheckBox.isChecked()){
                        q4 = "Q4: " + ansFourOneCheckBox.getText().toString().trim();
                        yourAnswers.add(3, q4);
                    }else{
                        yourAnswers.add(3, "Q4: Not selected");
                    }
                }
                if(ansFiveRadioButton.isChecked()){
                    TotalObtainedScore += 10;
                    String q5 = "Q5: " + yourAnsFiveRadioButton.getText().toString().trim();
                    yourAnswers.add(4, q5);
                }
                else{
                    if(yourAnsFiveRadioButton != null){
                        String q5 = "Q5: " + yourAnsFiveRadioButton.getText().toString().trim();
                        yourAnswers.add(4, q5);
                    }else{
                        yourAnswers.add(4, "Q5: Not selected");
                    }
                }

                if (ansSixEditText.getText().toString().matches(getString(R.string.ans_six_two))){
                    TotalObtainedScore += 10;
                    String q6 = "Q6: " + ansSixEditText.getText().toString().trim();
                    yourAnswers.add(5, q6);
                }
                else{
                    if(!TextUtils.isEmpty(ansSixEditText.getText().toString())){
                        String q6 = "Q6: " + ansSixEditText.getText().toString().trim();
                        yourAnswers.add(5, q6);
                    }else{
                        yourAnswers.add(5, "Q6: EditText is empty.");
                    }
                }
                if(ansSevenRadioButton.isChecked()){
                    TotalObtainedScore += 10;
                    String q7 = "Q3: " + yourAnsSevenRadioButton.getText().toString().trim();
                    yourAnswers.add(6, q7);
                }
                else{
                    if(yourAnsSevenRadioButton != null){
                        String q7 = "Q3: " + yourAnsSevenRadioButton.getText().toString().trim();
                        yourAnswers.add(6, q7);
                    }
                    else{
                        yourAnswers.add(6, "Q7: Not selected");
                    }
                }

                if (ansEightCheckBox.isChecked() && !ansEightTwoCheckBox.isChecked() && !ansEightOneCheckBox.isChecked() && !ansEightFourCheckBox.isChecked()){
                    TotalObtainedScore += 10;
                    String q8 = "Q8: " + ansEightCheckBox.getText().toString().trim();
                    yourAnswers.add(7, q8);
                }
                else{
                    String q8;
                    if(ansEightTwoCheckBox.isChecked()){
                        q8 = "Q8: " + ansEightTwoCheckBox.getText().toString().trim();
                        yourAnswers.add(7, q8);
                    }
                    else if(ansEightOneCheckBox.isChecked()){
                        q8 = "Q8: " + ansEightOneCheckBox.getText().toString().trim();
                        yourAnswers.add(7, q8);
                    }
                    else if(ansEightFourCheckBox.isChecked()){
                        q8 = "Q8: " + ansEightFourCheckBox.getText().toString().trim();
                        yourAnswers.add(7, q8);
                    }else{
                        yourAnswers.add(7, "Q8: Not selected");
                    }
                }

                if(ansNineRadioButton.isChecked()){
                    TotalObtainedScore += 10;
                    String q9 = "Q9: " + yourAnsNineRadioButton.getText().toString().trim();
                    yourAnswers.add(8, q9);
                }
                else{
                    if(yourAnsNineRadioButton != null){
                        String q9 = "Q9: " + yourAnsNineRadioButton.getText().toString().trim();
                        yourAnswers.add(8, q9);
                    }
                    else{
                        yourAnswers.add(8, "Q9: Not selected");
                    }
                }
                if (ansTenRadioButton.isChecked()){
                    TotalObtainedScore += 10;
                    String q10 = "Q10: " + yourAnsTenRadioButton.getText().toString().trim();
                    yourAnswers.add(9, q10);
                }
                else{
                    if(yourAnsTenRadioButton != null){
                        String q10 = "Q10: " + yourAnsTenRadioButton.getText().toString().trim();
                        yourAnswers.add(9, q10);
                    }
                    else{
                        yourAnswers.add(9, "Q10: Not Selected");
                    }

                }
                String obtainedScore = String.valueOf(TotalObtainedScore);
                TotalMistakeScore = TotalScore - TotalObtainedScore;
                String mistakeScore = String.valueOf(TotalMistakeScore);
                Intent i = new Intent(QuizActivity.this, ScoreActivity.class);
                i.putExtra("scoreKey", obtainedScore);
                i.putExtra("yourAnswers", yourAnswers);
                startActivity(i);
                break;
        }
    }
}
