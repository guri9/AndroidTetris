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
    public static Thread gamet;


    ArrayList<GameUnit> placed;

    public Game(){

        gamet = new Thread(new Runnable() {
            @Override
            public void run() {
                gameHndler();
            }
        });

        ma = new MainActivity();
        gg = ma.gg;

        placed = new ArrayList<>();

        GameUnit gu = new GameUnit(yellow, 5, 0);
        placed.add(gu);
        current = gu;
        draw();

    }

    public void gameHndler(){
        while(true){
            Log.d("sleep", "start");
            long millis = 3000;

            try{
                Thread.sleep(3000);
            }catch (Exception e){}

            Log.d("sleep", "resuming...");


            dropCurrent();
            draw();
        }
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

    public void start(){

        //changes
        //gamet.start();

        runGame = true;
        while(runGame){

//        Log.d("sleep", "start");
//        SystemClock.sleep(3000);
//        Log.d("sleep", "resuming...");


            //dropCurrent();
            //draw();

            runGame = false;

        }


    }
    public void dropCurrent(){
        current.drop();
        Log.d("X val", String.valueOf(current.getX()));
        Log.d("Y val", String.valueOf(current.getY()));
        draw();
    }

    public void endGame(){
        runGame = false;
    }


}
