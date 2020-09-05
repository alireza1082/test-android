package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

public class musicActivity extends AppCompatActivity {

    Button start;
    SeekBar volume_seek , track_seek;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
/*      VideoView videoView = findViewById(R.id.video);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.ali);
        videoView.start();
        MediaController controller = new MediaController(this);
        controller.setAnchorView(videoView);
        videoView.setMediaController(controller);
 */
        final MediaPlayer player = MediaPlayer.create(getApplicationContext() , R.raw.naziinbaroon);
//        player.start();
        start = findViewById(R.id.musicStart);
        volume_seek = findViewById(R.id.volume_seek);
        track_seek = findViewById(R.id.progress_seek);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(start.getText());
                if (start.getText().equals("start")) {
                    player.start();
                    start.setText("pause");
                }
                else if (start.getText().equals("pause")) {
                    player.pause();
                    start.setText("start");
                }
            }
        });

        volume_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC , progress , 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        volume_seek.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        volume_seek.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

    }
}