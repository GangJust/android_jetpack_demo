package com.example.vl.utils;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;

public class ColorUtil {

    private ColorUtil() {
        ///
    }

    @ColorInt
    public static int randomColor() {
        int r = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        return Color.rgb(r, g, b);
    }

    @ColorInt
    public static int randomColor(int alpha) {
        int r = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        return Color.argb(alpha, r, g, b);
    }

    @ColorInt
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int randomColor(float alpha) {
        float r = (float) (Math.random() * 255);
        float g = (float) (Math.random() * 255);
        float b = (float) (Math.random() * 255);
        return Color.argb(alpha, r, g, b);
    }
}
