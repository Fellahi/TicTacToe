package com.karimh16.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View v){
        int cellID = 0;
       Button buttonSelected = (Button) v;
       switch (buttonSelected.getId()){
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

    public void playGame(int cellID, Button button){
        Log.d("player", String.valueOf(cellID));

        if(activePlayer){
            button.setBackground(this.getResources().getDrawable(R.drawable.x));
            player1.add(cellID);
        }else{
            button.setBackground(this.getResources().getDrawable(R.drawable.o));
            player2.add(cellID);
        }
        button.setEnabled(false);
        activePlayer = !activePlayer;
    }

    public void reset(View view){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}
