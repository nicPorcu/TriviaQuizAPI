package com.example.nicolo.triviaquizapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.example.nicolo.triviaquizapi.MainActivity.TAG;

/**
 * Created by per6 on 1/23/18.
 */

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.MyViewHolder>{
    private List<Results> questionlist;
    private Context context;
    private RecyclerViewClickListener recyclerViewClickListener;

    public WordAdapter(List<Results> questionList, Context context, RecyclerViewClickListener listener) {
        this.questionlist = questionList;
        this.context = context;
        recyclerViewClickListener=listener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_item,parent,false);

        return new MyViewHolder(itemView, recyclerViewClickListener);
    }

    @Override
    public void onBindViewHolder(WordAdapter.MyViewHolder holder, int position) {
            String text=questionlist.get(position).getQuestion();
            text = fixQuestion(text);


            holder.questionText.setText(text);
        Log.d(TAG, "onBindViewHolder: ques"+questionlist.get(position).getCorrectAnswer());



     //   holder.questionText.setText(question.toString());
//        holder.questionText.setText(question.getResults().get(0).getQuestion());
   //     holder.answerText.setText(question.getResults().get(position).getCorrectAnswer());

    }

    private String fixQuestion(String text) {
        while (text.indexOf("&quot;")>= 0){
            Log.d(TAG, "fixQuestion: "+text);
            text= text.substring(0,text.indexOf("&quot;"))+"\""+ text.substring(text.indexOf("quot;")+5);

        }
        if(text.indexOf("&#039;")>0){
            Log.d(TAG, "fixQuestion: "+text);
            text= text.substring(0,text.indexOf("&#039;"))+"'"+ text.substring(text.indexOf("&#039;")+6);
        }
        return text;
    }

    @Override
    public int getItemCount() {
        return questionlist.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView questionText;
        public Button trueButton, falseButton;
        private RecyclerViewClickListener recyclerViewClickListener;


        public MyViewHolder(View itemView, RecyclerViewClickListener listener) {

            super(itemView);
            questionText= itemView.findViewById(R.id.questionTextView);
            trueButton=itemView.findViewById(R.id.true_button);
            falseButton=itemView.findViewById(R.id.false_button);
            trueButton.setOnClickListener(this);
            falseButton.setOnClickListener(this);
            recyclerViewClickListener = listener;

        }
        @Override
        public void onClick(View view) {
            recyclerViewClickListener.onClick(view, getAdapterPosition());
        }
    }

    public List<Results> getQuestionlist() {
        return questionlist;
    }


//    public void onClick(View view)
//    {
//
//        switch (view.getId()){
//            case R.id.true_button:
//                if(questionlist.get(0).getCorrectAnswer().equals("true")) {
//                    Toast.makeText(context, "Correct", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(context, "Incorrect", Toast.LENGTH_SHORT).show();
//
//                }
//
//                break;
//            case R.id.false_button:
//                Toast.makeText(context, "False", Toast.LENGTH_SHORT).show();
//
//
//                break;
//
//        }
//    }
}
