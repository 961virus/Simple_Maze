package com.example.virus.simplemaze;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by virus on 08.11.2016.
 */

public class MainThread extends Thread{

    private static final String TAG= MainActivity.class.getSimpleName();
    private SurfaceHolder surfaceHolder;
    private DrawView gamePanel;

    public MainThread(SurfaceHolder surfaceHolder, DrawView gamePanel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }
    //флаг, указывающий на то, что игра запущена.

    private boolean running;
    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        Canvas canvas;
        Log.d(TAG, "Starting game loop");
        while (running) {
            canvas = null;
            // пытаемся заблокировать canvas
            // для изменение картинки на поверхности
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    // здесь будет обновляться состояние игры
                    // и формироваться кадр для вывода на экран
                    this.gamePanel.onDraw(canvas);//Вызываем метод для рисования
                }
            } finally {
                // в случае ошибки, плоскость не перешла в
                //требуемое состояние
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
