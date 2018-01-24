package com.example.nicolo.triviaquizapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.DefaultItemAnimator;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Question questionObject;
    private List<Results> questionList;
    private WordAdapter adapter;
    public static final String TAG= "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter=new WordAdapter(questionList,this);
        recyclerView.setAdapter(adapter);
        questionList=new ArrayList<>();




        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(TriviaAPI.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TriviaAPI api= retrofit.create(TriviaAPI.class);
        Call<Question> call= api.getQuestion(10);
        call.enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                if(response.body()==null)
                {
                    Log.d(TAG, "onResponse: is null");
                }
                Log.d(TAG, "onResponse: "+response.body().getResponseCode());
                questionObject =response.body();
                Log.d(TAG, "onResponse: "+ questionObject.getResults().get(0).getQuestion());

                questionList.addAll(questionObject.getResults());

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " +t.getMessage());
            }


        });

    }
}
