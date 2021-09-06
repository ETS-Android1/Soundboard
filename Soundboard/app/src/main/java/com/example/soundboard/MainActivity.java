package com.example.soundboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<BoardObject> boardList = new ArrayList<>();

    RecyclerView SoundView;
    SoundboardRecyclerAdapter SoundAdapter = new SoundboardRecyclerAdapter(boardList);
    RecyclerView.LayoutManager SoundLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SoundView = (RecyclerView) findViewById(R.id.soundboardRecyclerView);

        SoundLayoutManager = new GridLayoutManager(this, 3);

        List<String> nameList = Arrays.asList(getResources().getStringArray(R.array.soundNames));

        BoardObject[] boardItems = {new BoardObject(nameList.get(0), R.raw.airhorn), new BoardObject(nameList.get(1), R.raw.crash), new BoardObject(nameList.get(2), R.raw.easy) };

        boardList.addAll(Arrays.asList(boardItems));

        SoundView.setLayoutManager(SoundLayoutManager);

        SoundView.setAdapter(SoundAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventHandler.releaseMediaPlayer();
    }
}