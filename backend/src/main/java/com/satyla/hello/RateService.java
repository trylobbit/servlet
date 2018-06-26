package com.satyla.hello;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class RateService {

    private static final Gson GSON = new GsonBuilder().create();
    private static final String API_URL = "http://api.nbp.pl/api/exchangerates/rates/c/eur/";
    private static final String FORMAT = "/?format=json";
    private final Cache<String, Rate> cache;

    public RateService() {

        cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(20, TimeUnit.SECONDS)
                .build();
    }

    public Rate getRateForDate(String date) throws ExecutionException {
        return cache.get(date, () -> getRate(date));
    }

    private Rate getRate(String date) throws IOException {
        String exchangeUrl = API_URL + date + FORMAT;
        URL url = new URL(exchangeUrl);
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String inputLine;
        StringBuilder stringRate = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {

            stringRate.append(inputLine);
        }
        in.close();

        return GSON.fromJson(stringRate.toString(), Rate.class);
    }
}
