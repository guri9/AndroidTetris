package com.example.tetrisproj;

public class GameUnit {

    private int x, y, preX, preY;
    private String color;

    public GameUnit(String color){
        this.color = color;

    }
    public GameUnit(String color, int x, int y){
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

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void moveR(){
        preX = x;
        if(x < 9)
            x++;
    }
    public void moveL(){
        preX = x;
        if(x > 0)
            x--;
    }
    public void drop(){
        preY = y;
        if(y < 19)
            y++;
    }
    public void delet(){
        color = "grey";
    }
}
