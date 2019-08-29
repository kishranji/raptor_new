package com.raptor.app;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.widget.TextView;

public class AppHelper {
    public static void setTextViewGradient(TextView aTextView, String aText, int[] aArray) {

        TextPaint paint = aTextView.getPaint();
        float width = paint.measureText(aText);

        Shader textShader = new LinearGradient(0, 0, width, aTextView.getTextSize(),
                aArray, null, Shader.TileMode.CLAMP);

        aTextView.getPaint().setShader(textShader);
    }
}
