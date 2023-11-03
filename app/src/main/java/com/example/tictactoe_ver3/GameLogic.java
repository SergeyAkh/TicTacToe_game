package com.example.tictactoe_ver3;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.security.cert.TrustAnchor;

public class GameLogic {
    public String[] playerNames = {"Player 1", "Player 2"};
    private int [][] gameBoard;
    private Button playAgainBTN;
    private Button homeBTN;
    private TextView playerTurn;
    // 1st ell - row, 2ell - col, 3el - line_type
    private int [] winType = {-1,-1,-1};
    private int player = 1;
    GameLogic (){
        gameBoard = new int[3][3];
        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                gameBoard[r][c] = 0;
            }
        }
    }
    public boolean updateGameBoard(int row, int col){
//        int boardFilled = 0;
        if (gameBoard[row-1][col-1] == 0){
            gameBoard[row-1][col-1] = player;
            if (player == 1){
                playerTurn.setText((playerNames[1] + "'s Turn"));
//                boardFilled += 1;
            }
            else{
                playerTurn.setText((playerNames[0] + "'s Turn"));
//                boardFilled += 1;
            }
            return true;

        }
        else {
            return false;
        }
    }

    public boolean winnerCheck () {
        boolean isWinner = false;
        //Horizontal check (winType == 1)
        for (int r = 0; r<3; r++) {
            if (gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] &&
            gameBoard[r][0] != 0){
                winType = new int[] {r, 0, 1};
                isWinner = true;
            }
        }
        //Vertical Check (winType == 2)
        for (int c = 0; c<3; c++) {
            if (gameBoard[0][c] == gameBoard[1][c] && gameBoard[0][c] == gameBoard[2][c] &&
                    gameBoard[0][c] != 0){
                winType = new int[] {0, c, 2};
                isWinner = true;
            }
        }
        //Diagonal(negative) check (winType == 3)
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] &&
                gameBoard[0][0] != 0){
            winType = new int[] {0, 2, 3};
            isWinner = true;
        }
        //Diagonal(positive) check (winType == 4)
        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] &&
                gameBoard[2][0] != 0){
            winType = new int[] {2, 2, 4};
            isWinner = true;
        }
        int boardFilled = 0;

        for (int r=0;r<3;r++){
            for (int c=0;c<3;c++){
                if (gameBoard[r][c] != 0){
                    boardFilled += 1;
                }
            }
        }

        if (isWinner) {
            playerTurn.setText(playerNames[player-1] + " is a Winner");
            return true;
        }
        else if(boardFilled == 9){
            playerTurn.setText("Tie Game!!");
            return true;
        }
        else {return false;}
    }

    public void resetGame(){
        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                gameBoard[r][c] = 0;
            }
        }
        setPlayer(1);
        player = 1;
        playerTurn.setText((playerNames[0] + "'s Turn"));

    }


    public void setPlayAgainBTN(Button playAgainBTN) {
        this.playAgainBTN = playAgainBTN;
    }

    public void setHomeBTN(Button homeBTN) {
        this.homeBTN = homeBTN;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }
    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public int[] getWinType(){
        return winType;
    }
}
