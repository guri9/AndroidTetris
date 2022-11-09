package com.example.tetrisproj;

import static com.example.tetrisproj.Colors.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.gridlayout.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    public static GridLayout gg;
    static GameUnit current;
    public static Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        current = new GameUnit(yellow, 0, 0);

        gg = findViewById(R.id.gameGrid);
        gg.removeAllViews();

        gg.setColumnCount(10);
        gg.setRowCount(20);

        GridLayout.Spec rowSpan = GridLayout.spec(GridLayout.UNDEFINED, 1);
        GridLayout.Spec colspan = GridLayout.spec(GridLayout.UNDEFINED, 1);

        gg.setPadding(70, 70, 10, 10);

        GridLayout.LayoutParams gridParam = new GridLayout.LayoutParams(rowSpan, colspan);
        gridParam.setMargins(25, 25, 325, 625);

        gg.setLayoutParams(gridParam);

        for (int i = 0; i < 200; i++)
            gg.addView(new UnitView(getApplicationContext()));

        game = new Game();
        game.start();

    }

    @Nullable
    public GridLayout getGameGrid() {
        return gg;
    }

    public void endGame(View v){
        game.endGame();
    }
    public void drop(View v){
        game.dropCurrent();
    }
    public void leftClick(View v) {
        game.moveLCurrent();

    }
    public void rotate(View v){
        game.rotateCurrent();
    }
    public void rightClick(View v){
        game.moveRCurrent();
    }
}