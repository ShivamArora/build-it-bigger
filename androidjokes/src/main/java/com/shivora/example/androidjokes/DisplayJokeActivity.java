package com.shivora.example.androidjokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE_TEXT = "extra_joke_text";

    TextView tvJokeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(EXTRA_JOKE_TEXT)) {
            String jokeText = intent.getStringExtra(EXTRA_JOKE_TEXT);
            tvJokeText = findViewById(R.id.tv_joke_text);
            tvJokeText.setText(jokeText);
        }
    }
}
