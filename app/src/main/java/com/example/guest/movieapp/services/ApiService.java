package com.example.guest.movieapp.services;

import com.example.guest.movieapp.Constants;

import javax.security.auth.callback.Callback;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;

public class ApiService {

//    public static void findMovies(String title, Callback callback) {
//        String API_KEY = Constants.API_KEY;
//
//        OkHttpClient client = new OkHttpClient.Builder()
//                .build();
//
//        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_KEY).newBuilder();
//        urlBuilder.addQueryParameter(Constants.API_KEY, title);
//        String url = urlBuilder.build().toString();
//
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        Call call = client.newCall(request);
//        call.enqueue(callback);
//    }
}
