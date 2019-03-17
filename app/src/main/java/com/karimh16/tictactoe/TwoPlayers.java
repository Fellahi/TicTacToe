package com.karimh16.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class TwoPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_players);
    }

    int nbrBut = 0;

    public void buttonClicked(View v) {
        nbrBut++;
        int cellID = 0;
        Button buttonSelected = (Button) v;
        switch (buttonSelected.getId()) {
            case R.id.bt1:
                cellID = 1;
                break;
            case R.id.bt2:
                cellID = 2;
                break;
            case R.id.bt3:
                cellID = 3;
                break;
            case R.id.bt4:
                cellID = 4;
                break;
            case R.id.bt5:
                cellID = 5;
                break;
            case R.id.bt6:
                cellID = 6;
                break;
            case R.id.bt7:
                cellID = 7;
                break;
            case R.id.bt8:
                cellID = 8;
                break;
            case R.id.bt9:
                cellID = 9;
                break;
        }
        playGame(cellID, buttonSelected);
    }

    boolean activePlayer = true; // true - player 1; false - player 2
    ArrayList<Integer> player1 = new ArrayList<Integer>();
    ArrayList<Integer> player2 = new ArrayList<Integer>();

    AlertDialog.Builder builder;

    public void playGame(int cellID, Button button) {
        Log.d("player", String.valueOf(cellID));

        if (activePlayer) {
            button.setBackground(this.getResources().getDrawable(R.drawable.x));
            player1.add(cellID);
        } else {
            button.setBackground(this.getResources().getDrawable(R.drawable.o));
            player2.add(cellID);
        }
        button.setEnabled(false);
        activePlayer = !activePlayer;
        findWinner();
        if(winner!=-1) {
            builder = new AlertDialog.Builder(this);
            builder.setTitle("result");
            builder.setCancelable(true);
            builder.setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            if (winner == 0)
                builder.setMessage("draw");
            else if (winner == 1)
                builder.setMessage("the winner : player 1");
            else if (winner == 2)
                builder.setMessage("the winner : player 2");

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    int winner = -1; //-1 no winner, 1 player 1 won, 2 player 2 won

    public void findWinner() {
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner = 1;
        else if (player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner = 2;
            //row 2
        else if (player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner = 1;
        else if (player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner = 2;
            //row 3
        else if (player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner = 1;
        else if (player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner = 2;
            //col 1
        else if (player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner = 1;
        else if (player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner = 2;
            //col 2
        else if (player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner = 1;
        else if (player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner = 2;
            //col 3
        else if (player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner = 1;
        else if (player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner = 2;
            //diag 1
        else if (player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner = 1;
        else if (player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner = 2;
            //diag 2
        else if (player1.contains(3) && player1.contains(5) && player1.contains(7))
            winner = 1;
        else if (player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner = 2;
            //draw
        else if (nbrBut == 9)
            winner = 0;
    }

    public void reset(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}
