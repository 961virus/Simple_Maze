package com.example.virus.simplemaze;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by virus on 24.11.2016.
 */

public class Ball {

    private Paint paint; //кисть
    private int x;// координата X
    private int y;// координата Y
    private int radius = 10; //радиус круга
    private boolean touched;

    public Ball(Paint paint, int x, int y) {
        this.paint = paint;
        this.x = x;
        this.y = y;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isTouched() {
        return touched;
    }

    public void setTouched(boolean touched) {
        this.touched = touched;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(x,y, radius, paint);
    }

    public void handleActionDown(int eventX, int eventY) {
        if ((eventX >= (x - radius)) && (eventX <= (x + radius))) {
            if ((eventY >= (y - radius)) && (eventY <= (y + radius))) {
// переводим робот в режим перетаскивания
                setTouched(true);
            } else {
                setTouched(false);
            }
        } else {
            setTouched(false);
        }
    }
}
