package com.example.nicolo.triviaquizapi;

/**
 * Created by per6 on 1/23/18.
 */

public class Question {
    int responseCode;
    Results results;


    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
