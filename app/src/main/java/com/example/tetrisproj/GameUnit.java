package com.example.tetrisproj;

import static com.example.tetrisproj.Colors.*;

public class GameUnit {

    private int x, y, preX, preY;
    private Colors color;

    public GameUnit(Colors color){
        this.color = color;

    }
    public GameUnit(Colors color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
        preX = x;
        preY = y;
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

    public void moveR(){
        preY = y;
        preX = x;
        if(x < 9)
            x++;
    }
    public void moveL(){
        preY = y;
        preX = x;
        if(x > 0)
            x--;
    }
    public void drop(){
        preX = x;
        preY = y;
        if(y < 19)
            y++;
    }
    public void delet(){
        color = grey;
    }
}
