package com.darshilpatel.connect3;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    int currentActivePlayer = 0; // 0 = yellow, 1 = red

    int [] gameState = {2,2,2,2,2,2,2,2,2}; // 2 = unplayed piece
    int [][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};




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

        for (int[] winningPosition : winningPositions){
            if (gameState[winningPosition[0]] ==  gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2){

                String winner = "Red";

                if (gameState[winningPosition[0]]== 0 ){

                    winner = "Yellow";
                }

               TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);


                winnerMessage.setText(winner + " has won");

                LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

                layout.setVisibility(View.VISIBLE);

            }
        }


    }

    public void playAgin (View view){

        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

        layout.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



}

// TODO 1. Add game logic

