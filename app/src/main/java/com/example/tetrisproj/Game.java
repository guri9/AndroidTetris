package com.example.tetrisproj;
import static com.example.tetrisproj.Colors.*;

import android.os.Handler;
import android.util.Log;

import androidx.gridlayout.widget.GridLayout;
import java.util.ArrayList;

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

        placed = new ArrayList<>();

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
                preUv.delete();

            }
            for(int u = 0 ; u < gb.getUnits().length; u++){
                gu = gb.getUnits()[u];
                Log.d("Unit " + String.valueOf(u), String.valueOf(gu.getKey()));
                uv =  (UnitView) gg.getChildAt(gu.getIndex());
                uv.setFgColor(gu.getColor());
                uv.setNum(gu.getKey());
            }

        }
        ma.invalidateMenu();
    }

    private void handleGame(){

        if(!current.canMove()){
            current = new GameBlock();
            placed.add(current);
        }

        Log.d("handler", "hello handler");
        dropCurrent();
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
    private void checkLines(){
        boolean full = true;
        for(int i = 0; i < 20; i++){
            full = true;
            for (int j = 0; j < 10; j++){
                if(((UnitView)gg.getChildAt(i*10 + j)).getFgColor() == grey)
                    full = false;

            }


        }
    }
    private void delLine(int endIndex){
        int startIndex = endIndex-10;
        for(int i = startIndex; i < endIndex; i++){


        }
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
    public void rotateCurrent(){
        current.rotate();
        draw();
    }

    public void endGame(){
        runGame = false;
    }


}
