package com.example.pekerjakan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String titleKerja[], upahKerja[];
    Context context;

    public MyAdapter(Context ct, String pekerjaan[], String upah[]){
        context = ct;
        titleKerja=pekerjaan;
        upahKerja=upah;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.myrow, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.mytitleKerja.setText(titleKerja[position]);
    holder.myupahKerja.setText(upahKerja[position]);
    }

    @Override
    public int getItemCount() {
        return titleKerja.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mytitleKerja, myupahKerja;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mytitleKerja = itemView.findViewById(R.id.titleKerja);
            myupahKerja = itemView.findViewById(R.id.upahKerja);
        }
    }
}
