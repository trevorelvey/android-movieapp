package com.example.guest.movieapp.services;

import com.example.guest.movieapp.Constants;
import com.example.guest.movieapp.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.callback.Callback;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;

public class ApiService {

    public static void findMovies(String title, okhttp3.Callback callback) {
        String API_KEY = Constants.API_KEY;

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_KEY).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_KEY, title);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject dbJSON = new JSONObject(jsonData);
                JSONArray filmsJSON = dbJSON.getJSONArray("films");
                for (int i = 0; i < filmsJSON.length(); i++) {
                    JSONObject movieJSON = filmsJSON.getJSONObject(i);
                    String title = movieJSON.getString("original_title");
                    String description = movieJSON.getString("overview");
                    String releaseDate = movieJSON.getString("release_date");
                    String ratingAve = movieJSON.getString("vote_average");
                    String imageUrl = movieJSON.getString("poster_path");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
