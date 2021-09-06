package com.example.soundboard;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;

public class EventHandler {
    private static final String LOG_TAG = "EVENTHANDLER";
    private static MediaPlayer mp;
    public static void startMediaPlayer(View view, Integer soundID) {
        try {
            if (soundID != null) {
                if (mp != null) {
                    mp.reset();
                }
                mp = MediaPlayer.create(view.getContext(), soundID);
                mp.start();
            }

        } catch (Exception e) {
            Log.e(LOG_TAG, "MediaPlayer failed: " + e.getMessage());
        }
    }

    public static void releaseMediaPlayer() {
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }
}
