package com.example.cprogramming;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends Fragment {

    private CardView exit_view, next_view;
    private TextView question_view, option_a, option_b, option_c, option_d;
    private int score = 0;
    private String selectedAnswer = "";
    private int current_Qustionindex = 0;
    private final String TAG = "QuizActivity";
    private CardView qus_a, qus_b, qus_c, qus_d;
    private TextView first_number, second_number;
    private int counter = 0;
    private boolean isAdShowing = false;

    private MediaPlayer correctMediaPlayer;
    private MediaPlayer incorrectMediaPlayer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view=inflater.inflate(R.layout.fragment_quiz, container, false);

        exit_view = view.findViewById(R.id.exit_view);
        next_view = view.findViewById(R.id.next_view);
        question_view =view.findViewById(R.id.question_view);
        option_a = view.findViewById(R.id.option_a);
        option_b =view. findViewById(R.id.option_b);
        option_c = view.findViewById(R.id.option_c);
        option_d = view.findViewById(R.id.option_d);
        qus_a = view.findViewById(R.id.qus_a);
        qus_b = view.findViewById(R.id.qus_b);
        qus_c =view.findViewById(R.id.qus_c);
        qus_d =view.findViewById(R.id.qus_d);

        qus_a.setOnClickListener((View.OnClickListener) this);
        qus_b.setOnClickListener((View.OnClickListener) this);
        qus_c.setOnClickListener((View.OnClickListener) this);
        qus_d.setOnClickListener((View.OnClickListener) this);
        exit_view.setOnClickListener((View.OnClickListener) this);
        next_view.setOnClickListener((View.OnClickListener) this);

        first_number =view.findViewById(R.id.first_number);
        second_number =view. findViewById(R.id.second_number);

        load_question();
         return view;
    }

    @Override
    public void onClick(View v) {
        if (isAdShowing) return;

        CardView click_option = (CardView) v;

        if (click_option.getId() == R.id.exit_view) {
            Intent intent = new Intent(getActivity(), home.class);
            startActivity(intent);
            Toast.makeText(getActivity(), "Quiz is exit", Toast.LENGTH_SHORT).show();
        } else if (click_option.getId() == R.id.next_view) {
            if (!selectedAnswer.isEmpty()) {
                loadNextQuestion();
            } else {
                Toast.makeText(getActivity(), "Please select an answer", Toast.LENGTH_SHORT).show();
            }
        } else {
            resetOptionBackgrounds();
            if (v.getId() == R.id.qus_a) {
                selectedAnswer = option_a.getText().toString();
                highlightAnswer(qus_a, option_a);
            } else if (v.getId() == R.id.qus_b) {
                selectedAnswer = option_b.getText().toString();
                highlightAnswer(qus_b, option_b);
            } else if (v.getId() == R.id.qus_c) {
                selectedAnswer = option_c.getText().toString();
                highlightAnswer(qus_c, option_c);
            } else if (v.getId() == R.id.qus_d) {
                selectedAnswer = option_d.getText().toString();
                highlightAnswer(qus_d, option_d);
            }
        }
    }

    private void loadNextQuestion() {
        counter++;
        current_Qustionindex++;
        resetOptionBackgrounds();
        load_question();

        if (counter < 10) {
            second_number.setText(String.valueOf(counter));
        } else if (counter > 9) {
            String str = String.valueOf(counter);
            first_number.setText(String.valueOf(str.charAt(0)));
            second_number.setText(String.valueOf(str.charAt(1)));
        }
    }



    private void resetOptionBackgrounds() {
        qus_a.setBackgroundColor(Color.WHITE);
        qus_b.setBackgroundColor(Color.WHITE);
        qus_c.setBackgroundColor(Color.WHITE);
        qus_d.setBackgroundColor(Color.WHITE);
    }

    private void highlightAnswer(CardView selectedOption, TextView selectedTextView) {
        String correctAnswer = Quiz_Array.correctAnswer[current_Qustionindex];

        if (selectedTextView.getText().toString().equals(correctAnswer)) {
            selectedOption.setBackgroundColor(Color.GREEN);
            score++;
            correctMediaPlayer = MediaPlayer.create(getActivity(), R.raw.correct_sound);
            correctMediaPlayer.start();
        } else {
            selectedOption.setBackgroundColor(Color.RED);
            incorrectMediaPlayer = MediaPlayer.create(getActivity(), R.raw.incorrect_sound);
            incorrectMediaPlayer.start();
            if (option_a.getText().toString().equals(correctAnswer)) {
                qus_a.setBackgroundColor(Color.GREEN);
            } else if (option_b.getText().toString().equals(correctAnswer)) {
                qus_b.setBackgroundColor(Color.GREEN);
            } else if (option_c.getText().toString().equals(correctAnswer)) {
                qus_c.setBackgroundColor(Color.GREEN);
            } else if (option_d.getText().toString().equals(correctAnswer)) {
                qus_d.setBackgroundColor(Color.GREEN);
            }
        }
    }

    private void load_question() {
        if (current_Qustionindex ==50){
            showDialog();
            return;
        }
        animateOut(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                question_view.setText(Quiz_Array.qus[current_Qustionindex]);
                option_a.setText(Quiz_Array.choices[current_Qustionindex][0]);
                option_b.setText(Quiz_Array.choices[current_Qustionindex][1]);
                option_c.setText(Quiz_Array.choices[current_Qustionindex][2]);
                option_d.setText(Quiz_Array.choices[current_Qustionindex][3]);
                selectedAnswer = "";

                animateIn(null);
            }
        });
    }

    private void animateOut(Animator.AnimatorListener listener) {
        float translationX = -1000f;
        long duration = 300;

        question_view.animate().translationX(translationX).setDuration(duration);
        option_a.animate().translationX(translationX).setDuration(duration);
        option_b.animate().translationX(translationX).setDuration(duration);
        option_c.animate().translationX(translationX).setDuration(duration);
        option_d.animate().translationX(translationX).setDuration(duration).setListener(listener);
    }

    private void animateIn(Animator.AnimatorListener listener) {
        float translationX = 0f;
        long duration = 300;

        question_view.animate().translationX(translationX).setDuration(duration);
        option_a.animate().translationX(translationX).setDuration(duration);
        option_b.animate().translationX(translationX).setDuration(duration);
        option_c.animate().translationX(translationX).setDuration(duration);
        option_d.animate().translationX(translationX).setDuration(duration).setListener(listener);
    }

    private void showDialog() {
        View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.alert_dailog, null);

        CardView okView = dialogView.findViewById(R.id.ok_view);
        CardView cancelView = dialogView.findViewById(R.id.cancel_view);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        dialog.show();

        okView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),result.class);
                intent.putExtra("right_Ans", String.valueOf(score));
                startActivity(intent);
                Toast.makeText(getContext() ,"View your Score", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        cancelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                Toast.makeText(getActivity(), "Quiz is exited", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                dialog.dismiss();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (correctMediaPlayer != null) {
            correctMediaPlayer.release();
            correctMediaPlayer = null;
        }
        if (incorrectMediaPlayer != null) {
            incorrectMediaPlayer.release();
            incorrectMediaPlayer = null;
        }
    }

}