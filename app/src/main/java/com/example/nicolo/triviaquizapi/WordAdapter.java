package com.example.nicolo.triviaquizapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by per6 on 1/23/18.
 */

class WordAdapter extends RecyclerView.Adapter<WordAdapter.MyViewHolder>{
    private Question questions;
    private Context context;

    public WordAdapter(Question questions, Context context) {
        this.questions = questions;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_item,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordAdapter.MyViewHolder holder, int position) {
        Question question=questions.get(position);
        holder.questionText.setText(question.getResults().getQuestion());
        holder.answerText.setText(question.getResults().getCorrectAnswer());

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView questionText,answerText;

        public MyViewHolder(View itemView) {
            super(itemView);
            questionText= itemView.findViewById(R.id.questionTextView);
            answerText= itemView.findViewById(R.id.answerTextView);
        }
    }
}
