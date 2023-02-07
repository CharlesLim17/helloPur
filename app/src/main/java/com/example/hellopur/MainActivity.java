package com.example.hellopur;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //action bar, navigation, status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //declare set variables
        Button btnPet = findViewById(R.id.btnPet);
        TextView txtCongrats = findViewById(R.id.txtCongrats);

        //set media player
        mediaPlayer = MediaPlayer.create(this, R.raw.cat_sound);

        //spanning string in front end
        SpannableStringBuilder spannable = new SpannableStringBuilder("You petted the Cat!");
        spannable.setSpan(
                new ForegroundColorSpan(Color.rgb(127, 0, 255)),
                8, // start
                19, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        );

        txtCongrats.setText(spannable);
        txtCongrats.setVisibility(View.GONE);

        //button onclick listener
        btnPet.setOnClickListener(view -> {

            //to play media
            mediaPlayer.start();

            //to show text
            txtCongrats.setVisibility(View.VISIBLE);

            //to re hide text
            Handler handler = new Handler();
            handler.postDelayed(() -> txtCongrats.setVisibility(View.GONE), 2000);
        });
    }
}