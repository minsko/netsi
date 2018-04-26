package com.mattinsko.netsi;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SoundPool soundPool = null;
    private static int NETSPI_VAL = 42;
    private Map<Integer, Integer> soundMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
        try {
            int asset = soundPool.load(getAssets().openFd("netsi.mp3"), 1);
            soundMap.put(NETSPI_VAL, asset);
        } catch (Exception e) {
            e.printStackTrace();
            toast("Couldn't load netsi");
        }
        findViewById(R.id.pressBt).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        soundPool.play(soundMap.get(NETSPI_VAL), 0.9f, 0.9f, 0, 0, 1f);
    }

    private void toast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
