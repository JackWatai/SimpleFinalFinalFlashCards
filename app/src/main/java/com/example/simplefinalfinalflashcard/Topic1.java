package com.example.simplefinalfinalflashcard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Topic1 extends AppCompatActivity
        implements View.OnClickListener {

    private Button FButton;
    private Button TButton;
    private Button NEXTButton;
    private Button PREVButton;
    private TextView QUESTIONTextView;
    private int correct = 0;
    Button HOMEButton;

    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {

            new Question(R.string.b, true),
            new Question(R.string.c, true),
            new Question(R.string.d, false),
            new Question(R.string.e, true),


    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic1);

        HOMEButton = (Button) findViewById(R.id.button_home);
        HOMEButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Topic1.this, MainActivity.class);
                startActivity(intent);
            }
        });
        FButton = findViewById(R.id.button_false);
        TButton = findViewById(R.id.button_true);
        NEXTButton = findViewById(R.id.button_next_question);
        PREVButton = findViewById(R.id.button_back_question);

        QUESTIONTextView = findViewById(R.id.textView_question);
        FButton.setOnClickListener(this);
        TButton.setOnClickListener(this);
        NEXTButton.setOnClickListener(this);
        PREVButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {

        switch (v.getId()) {
            case R.id.button_false:
                checkAnswer(false);
                break;

            case R.id.button_true:
                checkAnswer(true);
                break;

            case R.id.button_next_question:

                if (currentQuestionIndex < 5) {
                    currentQuestionIndex
                            = currentQuestionIndex + 1;

                    if (currentQuestionIndex == 4) {
                        QUESTIONTextView.setText(getString(
                                R.string.correct, correct));
                        NEXTButton.setVisibility(
                                View.INVISIBLE);
                        PREVButton.setVisibility(
                                View.INVISIBLE);
                        TButton.setVisibility(
                                View.INVISIBLE);
                        FButton.setVisibility(
                                View.INVISIBLE);
                        if (correct > 2)

                            QUESTIONTextView.setText(
                                    "SCORE: " + correct
                                            + " "
                                            + "OUT OF 4");

                        else;
                    }
                    else {
                        updateQuestion();
                    }
                }

                break;
            case R.id.button_back_question:
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex
                            = (currentQuestionIndex - 1)
                            % questionBank.length;
                    updateQuestion();
                }
        }
    }

    private void updateQuestion()
    {
        Log.d("Current",
                "onClick: " + currentQuestionIndex);

        QUESTIONTextView.setText(
                questionBank[currentQuestionIndex]
                        .getAnswer());

    }
    private void checkAnswer(boolean userChooseCorrect)
    {
        boolean answerIsTrue
                = questionBank[currentQuestionIndex]
                .isAnswerTrue();

        int toastMessageId;

        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
            correct++;
        }
        else {

            toastMessageId = R.string.wrong_answer;
        }

        Toast
                .makeText(Topic1.this, toastMessageId,
                        Toast.LENGTH_SHORT)
                .show();
    }
}