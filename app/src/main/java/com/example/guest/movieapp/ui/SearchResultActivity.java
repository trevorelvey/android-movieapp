package com.example.guest.movieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.guest.movieapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchResultActivity extends AppCompatActivity {
    public static final String TAG = SearchResultActivity.class.getSimpleName();
    @Bind(R.id.resultsText) TextView mResultsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        mResultsText.setText("Here are the results for '" + title + "':");


    }
}
