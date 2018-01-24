package com.example.nicolo.triviaquizapi;

import java.util.List;

/**
 * Created by per6 on 1/23/18.
 */

public class Question {
    int responseCode;
    List<Results> results;


    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Question{" +
                "responseCode=" + responseCode +
                '}';
    }
}
