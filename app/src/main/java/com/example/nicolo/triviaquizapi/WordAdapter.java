package com.example.nicolo.triviaquizapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import static com.example.nicolo.triviaquizapi.MainActivity.TAG;

/**
 * Created by per6 on 1/23/18.
 */

class WordAdapter extends RecyclerView.Adapter<WordAdapter.MyViewHolder>{
    private List<Results> questionlist;
    private Context context;

    public WordAdapter(List<Results> questionList, Context context) {
        this.questionlist = questionList;
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
        List<Results> questions= this.questionlist;
        if(questions==null){
            Log.d(TAG, "onBindViewHolder: isNull");
        }
        else {
            holder.questionText.setText(questions.get(position).getQuestion());
        }
     //   holder.questionText.setText(question.toString());
//        holder.questionText.setText(question.getResults().get(0).getQuestion());
   //     holder.answerText.setText(question.getResults().get(position).getCorrectAnswer());

    }

    @Override
    public int getItemCount() {
        return 10;
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
