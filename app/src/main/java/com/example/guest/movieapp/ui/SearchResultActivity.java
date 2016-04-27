package com.example.guest.movieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.guest.movieapp.R;
import com.example.guest.movieapp.models.Movie;
import com.example.guest.movieapp.services.ApiService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SearchResultActivity extends AppCompatActivity {
    public ArrayList<Movie> mMovies = new ArrayList<>();
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

        getMovies(title);
    }

    private void getMovies(String title) {
        final ApiService apiService = new ApiService();

        ApiService.findMovies(title, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mMovies = ApiService.processResults(response);

                SearchResultActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String[] movieNames = new String [mMovies.size()];
                        for (int i = 0; i < movieNames.length; i++) {
                            movieNames[i] = mMovies.get(i).getTitle();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(SearchResultActivity.this, android.R.layout.simple_list_1, movieNames);
                        mListView.setAdapter(adapter);

                        for (Movie movie : mMovies) {
                            Log.d(TAG, "Title: " + movie.getTitle());
                            Log.d(TAG, "Synopsis: " + movie.getDescription());
                            Log.d(TAG, "Release Date: " + movie.getReleaseDate());
                            Log.d(TAG, "Average Rating: " + movie.getRatingAve());
                            Log.d(TAG, "Image URL: " + movie.getImageUrl());
                        }
                    }
                });
            }
        });
    }
}
