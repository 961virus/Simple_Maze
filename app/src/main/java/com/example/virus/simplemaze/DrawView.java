package com.example.virus.simplemaze;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.view.MotionEvent;

import java.util.Arrays;


/**
 * Created by virus on 26.10.2016.
 */

public class DrawView extends SurfaceView implements SurfaceHolder.Callback {

    Paint paint;

    private static final String TAG= MainActivity.class.getSimpleName();
    private MainThread thread;
    private Ball ball;

    public DrawView(Context context) {
        super(context);

        paint = new Paint();
        // Добавляем этот класс, как содержащий функцию обратного
        // вызова для взаимодействия с событиями
        getHolder().addCallback(this);

        ball = new Ball(paint,30, 30);
        // делаем  focusable, чтобы она могла обрабатывать сообщения
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //посылаем потоку команду на закрытие и дожидаемся,
        //пока поток не будет закрыт.
        boolean retry = true;
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                // пытаемся снова остановить поток thread
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()== MotionEvent.ACTION_DOWN) {
            //вызываем метод handleActionDown
            ball.handleActionDown((int)event.getX(),(int)event.getY());
            //если щелчек по нижне области экрана то выходим
            if (event.getY() > getHeight() - 50) {
                thread.setRunning(false);
                ((Activity) getContext()).finish();
            } else {
                Log.d(TAG, "Coords: x=" + event.getX() + ",y=" + event.getY());
            }
        } if (event.getAction() == MotionEvent.ACTION_MOVE) {
            // перемещение
            if (ball.isTouched()) {
                 // the droid was picked up and is being dragged
                ball.setX((int)event.getX());
                ball.setY((int)event.getY());
            }
        } if (event.getAction() == MotionEvent.ACTION_UP) {
            // отпускание
              if (ball.isTouched()) {
                  ball.setTouched(false);
                   }
              }
            return true;

    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(Color.BLACK);
        paint.setColor(Color.RED);
        ball.draw(canvas);
    }
}


