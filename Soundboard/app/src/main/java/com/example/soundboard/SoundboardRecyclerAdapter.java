package com.example.soundboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SoundboardRecyclerAdapter extends RecyclerView.Adapter<SoundboardRecyclerAdapter.SoundboardViewHolder> {

    private ArrayList<BoardObject> boardObjects;

    public SoundboardRecyclerAdapter (ArrayList<BoardObject> boardObjects) {
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
        final BoardObject obj = boardObjects.get(position);
        final Integer soundID = obj.getItemID();
        holder.itemTextView.setText(obj.getItemName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventHandler.startMediaPlayer(v, soundID);
            }
        });
    }

    @Override
    public int getItemCount() {
        return boardObjects.size();
    }

    public class SoundboardViewHolder extends RecyclerView.ViewHolder{

        TextView itemTextView;

        public SoundboardViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTextView = (TextView) itemView.findViewById(R.id.textViewItem);
        }
    }
}
