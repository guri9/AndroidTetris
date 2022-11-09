package com.example.tetrisproj;

import static com.example.tetrisproj.Colors.*;

import android.app.ActivityManager;
import android.util.Log;

import kotlin.Unit;

public class GameBlock {

    private GameUnit[] units;
    private Colors color;
    private static int key = 0;
    private boolean canMove;

    private int rotCount;
    GameUnit masterUnit;
    private Runnable[] movements;

    public GameBlock(){

        color = purple;
        key++;


//        units[0] = new GameUnit(color, 5, 0);
//        units[1] = new GameUnit(color, 4, 1);
//        units[2] = new GameUnit(color, 5, 1);
//        units[3] = new GameUnit(color, 6, 1);

        rotCount = 1;
        units = new GameUnit[4];
        for (int i = 0; i < units.length; i++){
            units[i] = new GameUnit(color, 5, 0);
            units[i].setKey(key);
        }

        masterUnit = new GameUnit(units[0]);

        movements = new Runnable[4];
        movements[0] = new Runnable() {
            @Override
            public void run() {
                generateLeft();
            }
        };
        movements[1] = new Runnable() {
            @Override
            public void run() {
                generateUnder();
            }
        };
        movements[2] = new Runnable() {
            @Override
            public void run() {
                generateRight();
            }
        };
        movements[3] = new Runnable() {
            @Override
            public void run() {
                generateAbove();
            }
        };

        genBlock();

        canMove = true;


    }

    public void genBlock(){
        masterUnit.move(units[0]);

        units[0].move(masterUnit);
        movements[rotCount%4].run();
        units[1].move(masterUnit);
        movements[(rotCount +1) %4].run();
        units[2].move(masterUnit);
        movements[(rotCount +1)%4].run();
        units[3].move(masterUnit);
        movements[(rotCount +1)%4].run();


    }
    public void rotate(){
        if(!canMove)
            return;
        rotCount++;
        genBlock();
    }

    private void generateLeft(){
        masterUnit.moveL();
    }
    private void generateRight(){
        masterUnit.moveR();
    }
    private void generateUnder(){
        masterUnit.drop();
    }
    private void generateAbove(){
        masterUnit.moveUp();
    }


    public void drop(){
        if(!canMove)
            return;
        for (int i = 0; i < units.length; i++){
            if(!units[i].canDrop()){
                canMove = false;
                return;
            }
        }
        for (int i = 0; i < units.length; i++){
            units[i].drop();
        }

    }
    public void moveL(){



        if (!canMove)
            return;
        for (int i = 0; i < units.length; i++){
            if(!units[i].canL())
                return;
        }
        for (int i = 0; i < units.length; i++){
            units[i].moveL();
        }
    }
    public void moveR(){
        if (!canMove)
            return;
        for (int i = 0; i < units.length; i++){
            if(!units[i].canR())
                return;
        }
        for (int i = 0; i < units.length; i++){
            units[i].moveR();
        }
    }
    public GameUnit[] getUnits()
    {
        return units;
    }
    public boolean canMove(){
        return canMove;
    }


}
