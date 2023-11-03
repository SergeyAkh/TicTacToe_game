package com.example.tictactoe_ver3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {
    private TicTieToeBoard ticTieToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);
        Button playAgainBTN = findViewById(R.id.playAgainBtn);
        Button homeBTN = findViewById(R.id.homeBtn);
        TextView playerTurn = findViewById(R.id.player_display);
        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");
        if (playerNames != null){
            playerTurn.setText((playerNames[0] + "'s Turn"));
        }
        ticTieToeBoard = findViewById(R.id.ticTieToeBoard);

        ticTieToeBoard.setUpGame(playAgainBTN,homeBTN,playerTurn,playerNames);

    }

    public void playAgainButtonClick (View view) {
        ticTieToeBoard.resetGame();
        ticTieToeBoard.invalidate();
    }

    public void homeButtonClick (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}