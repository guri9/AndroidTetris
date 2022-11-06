package com.example.tetrisproj;
import static com.example.tetrisproj.Colors.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;
import java.util.ArrayList;

import kotlin.Unit;

public class Game {

    UnitView[][] gmat;
    boolean runGame;
    MainActivity ma;
    GridLayout gg;
    GameUnit current;
    static Handler gameH;


    ArrayList<GameUnit> placed;

    public Game(){

        ma = new MainActivity();
        gg = ma.gg;

        gameH = new Handler();

        placed = new ArrayList<>();

        GameUnit gu = new GameUnit(yellow, 5, 0);
        placed.add(gu);
        current = gu;
        draw();

    }


    public void draw(){
        Log.d("draw", String.valueOf(placed.size()));
        GameUnit gu;
        UnitView uv;
        UnitView preUv;
        for(int i = 0; i < placed.size(); i++){
            gu = placed.get(i);
            preUv = (UnitView)gg.getChildAt(gu.getPreIndex());
            uv =  (UnitView) gg.getChildAt(gu.getIndex());

            preUv.delet();
            uv.setFgColor(gu.getColor());

        }
        ma.invalidateMenu();
    }

    private void handleGame(){

        Log.d("handler", "hello handler");
        dropCurrent();

        if(current.getY() == 19)
            endGame();
        draw();

        gameH.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (runGame)
                    handleGame();
            }
        }, 1000);

    }

    public void start(){

        runGame = true;
        handleGame();
    }
    public void dropCurrent(){
        current.drop();
        Log.d("X val", String.valueOf(current.getX()));
        Log.d("Y val", String.valueOf(current.getY()));
    }
    public void moveLCurrent(){
        current.moveL();
        draw();
    }
    public void moveRCurrent(){
        current.moveR();
        draw();
    }

    public void endGame(){
        runGame = false;
    }


}
