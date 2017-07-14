package com.bksapps.quizzler;

import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    // TODO: Declare constants here

    // TODO: Declare member variables here:
    TextView mQuestion;
    TextView mScore;
    ProgressBar mProgressBar;
    Button mTrueButton;
    Button mFalseButton;
    int mCurrentQuestion;
    int mIndex;
    boolean answer;
    int score=0;

    // TODO: Create question bank here:
    private TrueFalse [] mQuestionBank=new TrueFalse[]{
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13, true),
    };
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestion=(TextView)findViewById(R.id.question_text_view);
        mScore=(TextView)findViewById(R.id.score);
        mProgressBar=(ProgressBar) findViewById(R.id.progress_bar);
        mTrueButton=(Button) findViewById(R.id.true_button);
        mFalseButton=(Button)findViewById(R.id.false_button);
        mProgressBar.setMax(mQuestionBank.length);
        mCurrentQuestion=mQuestionBank[mIndex].getQuestionID();
        mQuestion.setText(mCurrentQuestion);
        mScore.setText("Score "+score+"/"+mQuestionBank.length);


        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                updateQuestions();

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateQuestions();
            }
        });
    }

    private void updateQuestions(){
        mIndex+=1;
        if(mIndex != mQuestionBank.length) {
            mCurrentQuestion = mQuestionBank[mIndex].getQuestionID();
            mQuestion.setText(mCurrentQuestion);
        }else{
            new AlertDialog.Builder(MainActivity.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Game Over")
                    .setMessage("You Scored "+ score+ " Points")
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .show();
        }
    }

    private void checkAnswer(boolean userAnswer) {
        if (mIndex != mQuestionBank.length) {
            answer = mQuestionBank[mIndex].getAnswer();
            if (answer == userAnswer) {
                score = score + 1;
                mScore.setText("Score " + score + "/" + mQuestionBank.length);
                mProgressBar.setProgress(i + 1);
                i += 1;
                Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            } else {
                mScore.setText("Score " + score + "/" + mQuestionBank.length);
                Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            }
        }
    }
}


