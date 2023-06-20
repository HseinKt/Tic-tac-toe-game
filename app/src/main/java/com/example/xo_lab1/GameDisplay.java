package com.example.xo_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private TicTacToaBoard ticTacToaBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        Button playAgainBTN = findViewById(R.id.playAgain);
        Button homeBTN = findViewById(R.id.home_Button);
        TextView playerTurn = findViewById(R.id.player_display);

        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        if(playerNames != null){
            playerTurn.setText((playerNames[0]+"'s Turn"));
        }
        ticTacToaBoard = findViewById(R.id.ticTacToaBoard);

        ticTacToaBoard.setUpGame(playAgainBTN, homeBTN, playerTurn, playerNames);
    }

    public void playAgainButton(View view) {
        ticTacToaBoard.resetGame();
        ticTacToaBoard.invalidate();
    }

    public void homeButton(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}