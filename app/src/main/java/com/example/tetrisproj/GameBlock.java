package com.example.tetrisproj;

import static com.example.tetrisproj.Colors.*;

public class GameBlock {

    private GameUnit[] units;
    private Colors color;

    public GameBlock(){

        color = purple;
        units = new GameUnit[4];
        units[0] = new GameUnit(color, 5, 0);
        units[1] = new GameUnit(color, 4, 1);
        units[2] = new GameUnit(color, 5, 1);
        units[3] = new GameUnit(color, 6, 1);

    }
    public void drop(){
        for (int i = 0; i < units.length; i++){
            units[i].drop();
        }
    }
    public void moveL(){
        for (int i = 0; i < units.length; i++){
            units[i].moveL();
        }
    }
    public void moveR(){
        for (int i = 0; i < units.length; i++){
            units[i].moveR();
        }
    }
    public GameUnit[] getUnits()
    {
        return units;
    }


}
