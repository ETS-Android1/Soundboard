package com.example.soundboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SoundboardRecyclerAdapter extends RecyclerView.Adapter<SoundboardRecyclerAdapter.SoundboardViewHolder> {

    private String[] boardObjects;

    public SoundboardRecyclerAdapter (String[] boardObjects) {
        this.boardObjects = boardObjects;
    }

    @NonNull
    @Override
    public SoundboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item,null);
        return new SoundboardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SoundboardViewHolder holder, int position) {
        holder.itemTextView.setText(boardObjects[position]);
    }

    @Override
    public int getItemCount() {
        return boardObjects.length;
    }

    public class SoundboardViewHolder extends RecyclerView.ViewHolder{

        TextView itemTextView;

        public SoundboardViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTextView = (TextView) itemView.findViewById(R.id.textViewItem);
        }
    }
}
