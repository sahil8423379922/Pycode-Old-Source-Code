package com.priyanka.pycode;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
//import android.priyanka.pycode.R;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Fundamental_play_quiz extends AppCompatActivity {

    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private View decodeview;
    private int number = 0;
    private Button submit_quiz;
    private int count = 3;
    private Button buttonConfirmNext;
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private TextView lifecount;
    private ArrayList<Questions> questionList;
    private int questionCounter;
    private int questionTotalCount;
    private Questions currentQuestions;
    private boolean answerd;
    int getvalue;

   //scoreupdate mydb;
    private final Handler handler = new Handler();


    private int correctAns = 0, wrongAns = 0;

    private TimerDialog timerDialog;


    private PlayAudioForAnswers playAudioForAnswers;

    int FLAG = 0;

    int score = 0;


    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private CountDownTimer countDownTimer;
    private long timeleftinMillis;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundamental_play_quiz);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), startcourse.class));
            }
        });

        setupUI();
        submit_Quiz();
        submit_quiz.setEnabled(false);
        fetchDB();
        Log.i("BUGBUG", "onCreate() in QuizActivity");
        timerDialog = new TimerDialog(this);

        playAudioForAnswers = new PlayAudioForAnswers(this);
        //lifecount = findViewById(R.id.life_remaining);
        //lifecount.setText("3");
       // mydb = new scoreupdate(this);
        getscore();

    }

    private void getscore() {
        Intent intent = getIntent();
        getvalue =intent.getIntExtra("UserScore", 0);
       // Toast.makeText(this, "v", Toast.LENGTH_SHORT).show();

    }

    private void setupUI() {
        textViewQuestion = findViewById(com.priyanka.pycode.R.id.set1_question_containerr);
        textViewScore = findViewById(com.priyanka.pycode.R.id.set1_total_score);
        textViewQuestionCount = findViewById(com.priyanka.pycode.R.id.set1_total_question);
        textViewCountDown = findViewById(com.priyanka.pycode.R.id.set_1_timer);
        rbGroup = findViewById(com.priyanka.pycode.R.id.set1_radio_group);
        rb1 = findViewById(com.priyanka.pycode.R.id.set1_button1);
        rb2 = findViewById(com.priyanka.pycode.R.id.set1_button2);
        rb3 = findViewById(com.priyanka.pycode.R.id.set1_button3);
        rb4 = findViewById(com.priyanka.pycode.R.id.set1_button4);
        buttonConfirmNext = findViewById(com.priyanka.pycode.R.id.set1_next_button);
        decodeview = getWindow().getDecorView();
        submit_quiz = findViewById(R.id.submit_quiz_btn);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decodeview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            );
        }


    }


    public void fetchDB() {
        QuizDbHelper2 dbHelper = new QuizDbHelper2(this);
        questionList = dbHelper.getAllQuestions();
        startQuiz();

    }

    public void startQuiz() {

        questionTotalCount = 25;
        Collections.shuffle(questionList);

        showQuestions();   // calling showQuestion() method


        rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId) {

                    case com.priyanka.pycode.R.id.set1_button1:
                        rb1.setTextColor(ContextCompat.getColor(getApplicationContext(), com.priyanka.pycode.R.color.white));
                        rb2.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        rb4.setTextColor(Color.BLACK);
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.when_answer_selected));
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));


                        break;
                    case com.priyanka.pycode.R.id.set1_button2:
                        rb2.setTextColor(ContextCompat.getColor(getApplicationContext(), com.priyanka.pycode.R.color.white));
                        rb1.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        rb4.setTextColor(Color.BLACK);
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.when_answer_selected));
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));

                        break;

                    case com.priyanka.pycode.R.id.set1_button3:
                        rb3.setTextColor(ContextCompat.getColor(getApplicationContext(), com.priyanka.pycode.R.color.white));
                        rb2.setTextColor(Color.BLACK);
                        rb1.setTextColor(Color.BLACK);
                        rb3.setTextColor(ContextCompat.getColor(getApplicationContext(), com.priyanka.pycode.R.color.white));
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.when_answer_selected));
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));

                        break;

                    case com.priyanka.pycode.R.id.set1_button4:
                        rb4.setTextColor(ContextCompat.getColor(getApplicationContext(), com.priyanka.pycode.R.color.white));
                        rb2.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        rb1.setTextColor(Color.BLACK);
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.when_answer_selected));
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));

                        break;
                }

            }
        });

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!answerd) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        submit_quiz.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.select_button));
                        submit_quiz.setEnabled(true);
                        disabilignbutton();
                        quizOperation();
                    } else {


                        submit_quiz.setEnabled(false);
                        submit_quiz.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.not_clicked_background));
                        Toast.makeText(Fundamental_play_quiz.this, "Please Select the Answer ", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void showQuestions() {

        submit_quiz.setEnabled(false);
        submit_quiz.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.not_clicked_background));

        rbGroup.clearCheck();

        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));
        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));
        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));
        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.radio_button));

        rb1.setTextColor(Color.BLACK);
        rb2.setTextColor(Color.BLACK);
        rb3.setTextColor(Color.BLACK);
        rb4.setTextColor(Color.BLACK);


        if (questionCounter < questionTotalCount) {
            currentQuestions = questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestions.getQuestion());
            rb1.setText(currentQuestions.getOption1());
            rb2.setText(currentQuestions.getOption2());
            rb3.setText(currentQuestions.getOption3());
            rb4.setText(currentQuestions.getOption4());

            questionCounter++;
            answerd = false;
            buttonConfirmNext.setText("Confirm");

            textViewQuestionCount.setText("Questions: " + questionCounter + "/" + questionTotalCount);


            timeleftinMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();


        } else {

            // If Number of Questions Finishes then we need to finish the Quiz and Shows the User Quiz Performance


            Toast.makeText(this, "Quiz Finshed", Toast.LENGTH_SHORT).show();

            rb1.setClickable(false);
            rb2.setClickable(false);
            rb3.setClickable(false);
            rb4.setClickable(false);
            buttonConfirmNext.setClickable(false);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    finalResult();

                }
            }, 2000);
        }
    }

    private void quizOperation() {
        answerd = true;
        countDownTimer.cancel();

        RadioButton rbselected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbselected) + 1;

        checkSolution(answerNr, rbselected);

    }


    private void checkSolution(int answerNr, RadioButton rbselected) {

        switch (currentQuestions.getAnswerNr()) {
            case 1:
                if (currentQuestions.getAnswerNr() == answerNr) {
                    rb1.setBackground(ContextCompat.getDrawable(
                            this, R.drawable.correct_option_background));
                    rb1.setTextColor(Color.WHITE);
                    correctAns++;
                    number = 1;
                    score += 10;
                    textViewScore.setText("Score: " + String.valueOf(score));
                    FLAG = 1;
                    playAudioForAnswers.setAudioforAnswer(FLAG);


                } else {
                    changetoIncorrectColor(rbselected);
                    wrongAns++;
                    FLAG = 2;
                    playAudioForAnswers.setAudioforAnswer(FLAG);
                    rb1.setBackground(ContextCompat.getDrawable(
                            this, R.drawable.correct_option_background));
                    rb1.setTextColor(Color.WHITE);


                }
                break;
            case 2:
                if (currentQuestions.getAnswerNr() == answerNr) {

                    rb2.setBackground(ContextCompat.getDrawable(this, R.drawable.correct_option_background));
                    rb2.setTextColor(Color.WHITE);
                    number = 2;
                    correctAns++;
                    score += 10;
                    textViewScore.setText("Score: " + String.valueOf(score));
                    FLAG = 1;
                    playAudioForAnswers.setAudioforAnswer(FLAG);


                } else {
                    changetoIncorrectColor(rbselected);
                    wrongAns++;
                    rb2.setBackground(ContextCompat.getDrawable(this, R.drawable.correct_option_background));
                    rb2.setTextColor(Color.WHITE);
                    FLAG = 2;
                    playAudioForAnswers.setAudioforAnswer(FLAG);


                }
                break;

            case 3:
                if (currentQuestions.getAnswerNr() == answerNr) {

                    rb3.setBackground(ContextCompat.getDrawable(this, R.drawable.correct_option_background));
                    rb3.setTextColor(Color.WHITE);
                    number = 3;
                    correctAns++;
                    score += 10;
                    textViewScore.setText("Score: " + String.valueOf(score));

                    FLAG = 1;
                    playAudioForAnswers.setAudioforAnswer(FLAG);


                } else {
                    changetoIncorrectColor(rbselected);
                    wrongAns++;
                    rb3.setBackground(ContextCompat.getDrawable(this, R.drawable.correct_option_background));
                    rb3.setTextColor(Color.WHITE);
                    FLAG = 2;
                    playAudioForAnswers.setAudioforAnswer(FLAG);


                }
                break;
            case 4:
                if (currentQuestions.getAnswerNr() == answerNr) {
                    rb4.setBackground(ContextCompat.getDrawable(this, R.drawable.correct_option_background));
                    rb4.setTextColor(Color.WHITE);
                    number = 4;
                    correctAns++;
                    score += 10;
                    textViewScore.setText("Score: " + String.valueOf(score));

                    FLAG = 1;
                    playAudioForAnswers.setAudioforAnswer(FLAG);


                } else {
                    changetoIncorrectColor(rbselected);
                    wrongAns++;
                    rb4.setBackground(ContextCompat.getDrawable(this, R.drawable.correct_option_background));
                    rb4.setTextColor(Color.WHITE);
                    FLAG = 2;
                    playAudioForAnswers.setAudioforAnswer(FLAG);


                }
                break;

        }
        if (questionCounter == questionTotalCount) {
            buttonConfirmNext.setText("Confirm and Finish");
        }
    }











    void changetoIncorrectColor(RadioButton rbselected) {
        rbselected.setBackground(ContextCompat.getDrawable(this, R.drawable.wrong_answer_background));

        rbselected.setTextColor(Color.WHITE);
    }


    //  the timer code

    private void startCountDown() {

        countDownTimer = new CountDownTimer(timeleftinMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftinMillis = millisUntilFinished;

                updateCountDownText();
            }

            @Override
            public void onFinish() {

                timeleftinMillis = 0;
                updateCountDownText();

            }
        }.start();

    }


    private void updateCountDownText() {

        int minutes = (int) (timeleftinMillis / 1000) / 60;
        int seconds = (int) (timeleftinMillis / 1000) % 60;

        //  String timeFormatted = String.format(Locale.getDefault(),"02d:%02d",minutes,seconds);

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        textViewCountDown.setText(timeFormatted);


        if (timeleftinMillis < 10000) {


            textViewCountDown.setTextColor(ContextCompat.getColor(this, com.priyanka.pycode.R.color.red));

            FLAG = 3;
            playAudioForAnswers.setAudioforAnswer(FLAG);


        } else {
            textViewCountDown.setTextColor(ContextCompat.getColor(this, com.priyanka.pycode.R.color.white));
        }


        if (timeleftinMillis == 0) {


            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    timerDialog.timerDialog();

                }
            }, 2000);


        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("BUGBUG", "onRestart() in QuizActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("BUGBUG", "onStop() in QuizActivity");
        finish();

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("BUGBUG", "onPause() in QuizActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("BUGBUG", "onResume() in QuizActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("BUGBUG", "onStart() in QuizActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        Log.i("BUGBUG", "onDestroy() in QuizActivity");


    }


    private void finalResult() {

        Intent resultData = new Intent(Fundamental_play_quiz.this, Result.class);
        resultData.putExtra("UserScore", score);
        resultData.putExtra("CorrectQues", correctAns);
        resultData.putExtra("WrongQues", wrongAns);
        startActivity(resultData);




    }

    public void submit_Quiz() {

        submit_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                    showQuestions();
                    enabledbutton();
                } else {
                    Toast.makeText(Fundamental_play_quiz.this, "Please Select One Option", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    public void disabilignbutton() {


        rb1.setEnabled(false);
        rb2.setEnabled(false);
        rb3.setEnabled(false);
        rb4.setEnabled(false);

    }

    public void enabledbutton() {
        rb1.setEnabled(true);
        rb2.setEnabled(true);
        rb3.setEnabled(true);
        rb4.setEnabled(true);
    }


    @Override
    public void onBackPressed() {


        startActivity(new Intent(Fundamental_play_quiz.this, startcourse.class));


    }

}
