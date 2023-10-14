package com.loser.superfruit86.myapplication;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

// Custom shadow to text class
public class ShadowSpan extends CharacterStyle implements UpdateAppearance {
    private final float radius;
    private final float dx;
    private final float dy;
    private final int color;

    public ShadowSpan(float radius, float dx, float dy, int color) {
        this.radius = radius;
        this.dx = dx;
        this.dy = dy;
        this.color = color;
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        tp.setShadowLayer(radius, dx, dy, color);
    }
}
