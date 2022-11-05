package com.example.tetrisproj;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;

import androidx.gridlayout.widget.GridLayout;

import java.util.HashMap;

public class UnitView extends View {

    private static HashMap<String, Integer> colors = null;

    static int count = 0;
    Paint p;
    Rect rect;
    Canvas myCanvas;

    int width;
    int height;
    String bgColor;
    String fgColor;
    int num;

    public UnitView(Context context) {
        super(context);
        init();
    }

    private void init(){

        colors = new HashMap<String, Integer>();
        colors.put("purple", Color.parseColor("#7c33a1"));
        colors.put("yellow", Color.parseColor("#ede624"));
        colors.put("grey", Color.parseColor("#adadad"));
        colors.put("dark grey", Color.parseColor("#525252"));

        width = 70;
        height = width;

        this.setPadding(1, 1, 1, 1);

        this.setLayoutParams(new ViewGroup.LayoutParams(width, height));
        setBgColor("dark grey");
        setFgColor("grey");

    }
    @Override
    public void onDraw(Canvas canvas){
        myCanvas = canvas;
        p = new Paint();
        p.setColor(Color.parseColor(fgColor));
        rect = new Rect(2, 2, 68, 68);
        canvas.drawRect(rect,p );
    }

    public void setNum(int n){
        num = n;
    }
    public int getNum(){
        return num;
    }

    public void setBgColor(String c){
        bgColor = c;
        this.setBackgroundColor(colors.get(bgColor));
        this.invalidate();
    }
    public String getBgColor(){
        return bgColor;
    }

    public void delet(){
        setBgColor("dark grey");
        setFgColor("grey");
    }
    public void setFgColor(String c){
        fgColor = c;
        this.invalidate();
    }
    public String getFgColor(){
        return fgColor;
    }
}
