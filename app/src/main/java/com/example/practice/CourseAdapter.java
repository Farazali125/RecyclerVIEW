package com.example.practice;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    ArrayList<Courses> courses;
    public CourseAdapter(Context context, ArrayList<Courses> courses){

        this.context=context;
        this.courses=courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_layout, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {

       // Course course= new courses.get(position);

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public  class CourseViewHolder extends RecyclerView.ViewHolder{

        ImageView imageV;
        TextView titleTv;
        TextView durationTv;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            imageV=itemView.findViewById(R.id.imageV);
            titleTv=itemView.findViewById(R.id.titleTv);
            durationTv=itemView.findViewById(R.id.durationTv);

        }
    }
}
