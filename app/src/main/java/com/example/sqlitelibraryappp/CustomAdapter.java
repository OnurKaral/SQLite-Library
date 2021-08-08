package com.example.sqlitelibraryappp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context context;
    ArrayList books_id,books_title,books_author,books_pages;

    CustomAdapter(Context context,
                  ArrayList books_id,
                  ArrayList books_title,
                  ArrayList books_author,
                  ArrayList books_pages){

        this.context = context;
        this.books_id = books_id;
        this.books_title = books_title;
        this.books_author = books_author;
        this.books_pages = books_pages;



    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
      View view =  inflater.inflate(R.layout.my_rv_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.books_id.setText(String.valueOf(books_id.get(position)));
        holder.books_title.setText(String.valueOf(books_title.get(position)));
        holder.books_author.setText(String.valueOf(books_author.get(position)));
        holder.books_pages.setText(String.valueOf(books_pages.get(position)));
    }

    @Override
    public int getItemCount() {
        return books_id.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView books_id,books_title,books_author,books_pages;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            books_id = itemView.findViewById(R.id.books_id);
            books_title = itemView.findViewById(R.id.books_title);
            books_author = itemView.findViewById(R.id.books_author);
            books_pages = itemView.findViewById(R.id.books_pages);


        }
    }
}
