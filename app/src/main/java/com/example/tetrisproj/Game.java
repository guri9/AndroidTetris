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
// Blocks
public class Game {

    UnitView[][] gmat;
    boolean runGame;
    MainActivity ma;
    GridLayout gg;
    GameBlock current;
    static Handler gameH;


    ArrayList<GameBlock> placed;

    public Game(){

        ma = new MainActivity();
        gg = ma.gg;

        gameH = new Handler();

        placed = new ArrayList<GameBlock>();

        //GameUnit gu = new GameUnit(yellow, 5, 0);
        //placed.add(gu);
        //current = gu;

        GameBlock gb = new GameBlock();
        current = gb;
        placed.add(gb);
        draw();

    }


    public void draw(){
        Log.d("draw", String.valueOf(placed.size()));
        GameUnit gu;
        UnitView uv;
        UnitView preUv;
        GameBlock gb;

        for(int i = 0; i < placed.size(); i++){
            gb = placed.get(i);
            for(int u = 0 ; u < gb.getUnits().length; u++){
                gu = gb.getUnits()[u];
                preUv = (UnitView)gg.getChildAt(gu.getPreIndex());
                preUv.delet();

            }
            for(int u = 0 ; u < gb.getUnits().length; u++){
                gu = gb.getUnits()[u];
                uv =  (UnitView) gg.getChildAt(gu.getIndex());
                uv.setFgColor(gu.getColor());

            }

//            gu = placed.get(i);
//            preUv = (UnitView)gg.getChildAt(gu.getPreIndex());
//            uv =  (UnitView) gg.getChildAt(gu.getIndex());
//
//            preUv.delet();
//            uv.setFgColor(gu.getColor());

        }
        ma.invalidateMenu();
    }

    private void handleGame(){

        Log.d("handler", "hello handler");
        dropCurrent();


        draw();

        gameH.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (runGame)
                    handleGame();
            }
        }, 500);

    }

    public void start(){

        runGame = true;
        handleGame();
    }
    public void dropCurrent(){
        current.drop();
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
