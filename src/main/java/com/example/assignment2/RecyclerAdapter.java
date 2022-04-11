package com.example.assignment2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    String[] names;
    String[] prices;

    public RecyclerAdapter(Context context,String[] names,String[] prices){
        this.context=context;
        this.names=names;
        this.prices=prices;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.design,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,@SuppressLint("RecyclerView") int position) {
            holder.textNames.setText(names[position]);

            holder.textNames.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!view.isClickable()){
                        return;
                    }
                    Intent intent = new Intent(context,Details.class);
                    intent.putExtra("name",names[position]);

                    //determine if object is gift or flower
                    List<String> gifts = Arrays.asList(MyApplication.getGiftNames());
                    if (gifts.contains(names[position])){
                        intent.putExtra("price",prices[gifts.indexOf(names[position])+10]);//use the gifts price
                    }else{
                        List<String> flowers = Arrays.asList(MyApplication.getFlowerNames());
                        intent.putExtra("price",prices[flowers.indexOf(names[position])]);//use the flower prices
                    }

                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textNames;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNames = itemView.findViewById(R.id.textName);



        }

    }
}
