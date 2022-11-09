package com.example.tetrisproj;

import static com.example.tetrisproj.Colors.*;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.gridlayout.widget.GridLayout;

import kotlin.Unit;

public class GameUnit {

    private int x, y, preX, preY;
    private boolean canL, canR, canDrop;
    private Colors color;
    private GridLayout gg;
    private int key;

    public GameUnit(Colors color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
        preX = x;
        preY = y;
        canDrop = true;
        canL = true;
        canR = true;

        MainActivity mc = new MainActivity();
        gg = mc.getGameGrid();

    }
    public GameUnit(GameUnit gu){
        color = gu.getColor();
        x = gu.getX();
        y = gu.getY();
        preX = gu.getPreX();
        preY = gu.getPreY();
        canDrop = true;
        canL = true;
        canR = true;

    }


    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getIndex(){
        return y*10  +x ;
    }

    public int getPreX(){return preX;}
    public int getPreY(){return preY;}
    public int getPreIndex(){
        return preY*10  +preX ;
    }

    public Colors getColor(){
        return color;
    }
    public void setColor(Colors color){
        this.color = color;
    }

    public void setKey(int key){
        this.key = key;
    }
    public int getKey(){
        return key;
    }

    public void moveR(){
        preY = y;
        preX = x;
        x++;
    }
    public void moveL(){
        preY = y;
        preX = x;
            x--;
    }
    public void drop(){

        preX = x;
        preY = y;
        y++;
    }
    public void moveUp(){
        y--;
    }
    public void move(@Nullable GameUnit gu){
        if(gu == null){
            Log.d("wello", "its null");
            return;
        }

        preY = y;
        preX = x;
        this.x = gu.getX();
        this.y = gu.getY();
    }
    public boolean canL(){
        boolean flag = false;
        UnitView nextUv = (UnitView) gg.getChildAt(this.getIndex() - 1);

        if(nextUv.getFgColor() == grey || nextUv.getNum() == key)
            flag = true;

        if(x<=0)
            flag = false;

        return flag;

    }
    public boolean canR()
    {
        boolean flag = false;
        UnitView nextUv = (UnitView) gg.getChildAt(this.getIndex()+1);

        if(nextUv.getFgColor() == grey || nextUv.getNum() == key)
            flag = true;
        if (x >= 9)
            flag = false;

        return flag;
    }
    public boolean canDrop(){

        if(y >= 19)
            return false;

        UnitView nextUv = (UnitView) gg.getChildAt(this.getIndex()+10);
        return nextUv.getFgColor() == grey || nextUv.getNum() == key;

    }
    public void delet(){
        color = grey;
    }
}
