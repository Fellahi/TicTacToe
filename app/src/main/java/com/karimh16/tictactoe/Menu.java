package com.karimh16.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void next(View view){
        Intent intent;
        if(view.getId()==R.id.one)
            Toast.makeText(this, "comming soon...", Toast.LENGTH_SHORT).show();
        else if(view.getId()==R.id.two){
            intent = new Intent(Menu.this, TwoPlayers.class);
            startActivity(intent);
        }
    }
}
