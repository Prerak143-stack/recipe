package com.example.patel.recipe;

import android.support.annotation.NonNull;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class RecyclerAdapter extends RecyclerView.Adapter {



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(getLayoutID(), parent, false);

        return new RecyclerViewHolder(itemView);
    }

    public abstract int getLayoutID();

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        RecyclerViewHolder recyclerViewHolder = (RecyclerViewHolder) viewHolder;
        recyclerViewHolder.bindView(position);

    }

    @Override
    public int getItemCount() {

        return Recipes.names.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView itemImage;
        TextView itemText;
        private int index;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.itemImage);
            itemText = itemView.findViewById(R.id.itemText);

            itemView.setOnClickListener(this);

        }

        public void bindView(int position){
            index = position;

            itemText.setText(Recipes.names[position]);
            itemImage.setImageResource(Recipes.resourceIds[position]);
        }

        @Override
        public void onClick(View v) {

            onRecipeSelected(index);

        }
    }

    protected abstract void onRecipeSelected(int index);

}
