package com.example.tetrisproj;

import android.graphics.Color;

public enum Colors {
    yellow(Color.parseColor("#ede624")),
    purple(Color.parseColor("#7c33a1")),
    grey(Color.parseColor("#adadad")),
    dark_grey(Color.parseColor("#525252"));

    int cHash;
    Colors(int cHash) {
        this.cHash = cHash;
    }
    public int getCHash() {
        return cHash;
    }
}
