package com.darshilpatel.connect3;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    int currentActivePlayer = 0; // 0 = yellow, 1 = red

    int [] gameState = {2,2,2,2,2,2,2,2,2}; // 2 = unplayed piece

    public void dropIn (View view) {


        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 ){
            gameState[tappedCounter] = currentActivePlayer;



                counter.setTranslationY(-1000);

        if (currentActivePlayer == 0 ){
            counter.setImageResource(R.drawable.yellow);
            currentActivePlayer = 1;
        }  else {
                counter.setImageResource(R.drawable.red);
                currentActivePlayer = 0;
            }
        }


        counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

// TODO 1. Add game logic
 
