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

        BoardObject[] boardItems = {
                new BoardObject(nameList.get(0), R.raw.airhorn),
                new BoardObject(nameList.get(1), R.raw.crash),
                new BoardObject(nameList.get(2), R.raw.easy),
                new BoardObject(nameList.get(3), R.raw.renner),
                new BoardObject(nameList.get(4), R.raw.das),
                new BoardObject(nameList.get(5), R.raw.newcard),
                new BoardObject(nameList.get(6), R.raw.bone),
                new BoardObject(nameList.get(7), R.raw.ropers),
                new BoardObject(nameList.get(8), R.raw.young),
                new BoardObject(nameList.get(9), R.raw.waiting),
                new BoardObject(nameList.get(10), R.raw.price_is_right),
                new BoardObject(nameList.get(11), R.raw.hall),
                new BoardObject(nameList.get(12), R.raw.oates),
                new BoardObject(nameList.get(13), R.raw.salud),
                new BoardObject(nameList.get(14), R.raw.shinebox1),
                new BoardObject(nameList.get(15), R.raw.anymore),
                new BoardObject(nameList.get(16), R.raw.fresh),
                new BoardObject(nameList.get(17), R.raw.shinebox2),
                new BoardObject(nameList.get(18), R.raw.woltz),
                new BoardObject(nameList.get(19), R.raw.fredo),
                new BoardObject(nameList.get(20), R.raw.henderson),
                new BoardObject(nameList.get(21), R.raw.billy),
                new BoardObject(nameList.get(22), R.raw.odoyle1),
                new BoardObject(nameList.get(23), R.raw.odoyle2),
                new BoardObject(nameList.get(24), R.raw.odoyle3),
                new BoardObject(nameList.get(25), R.raw.colonel_sanders),
                new BoardObject(nameList.get(26), R.raw.snoop),
                new BoardObject(nameList.get(27), R.raw.nate),
                new BoardObject(nameList.get(28), R.raw.spooner1),
                new BoardObject(nameList.get(29), R.raw.spooner2),

        };

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