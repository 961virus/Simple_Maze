package com.example.virus.simplemaze;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.Arrays;

/**
 * Created by virus on 26.10.2016.
 */

public class DrawView extends View {

    int sizeRow = 10;
    int sizeColm = 5;
    int[][] drawingmatrix = new int[sizeRow][sizeColm];
        Paint p;
        Rect rect;
        public DrawView (Context context, AttributeSet attrs) {
            super(context, attrs);
            p = new Paint();
            rect = new Rect();
        }
        protected void onDraw(Canvas canvas) {
            //filling background with color
            canvas.drawARGB(18, 33, 108, 203);

            //painting config
            p.setColor(Color.BLACK);
            p.setStrokeWidth(1);

            // drawing figures
            //init arrays
            Arrays.fill(drawingmatrix[0],1);
            Arrays.fill(drawingmatrix[1],0);
            Arrays.fill(drawingmatrix[2],1);
            Arrays.fill(drawingmatrix[3],1);
            Arrays.fill(drawingmatrix[4],0);
            Arrays.fill(drawingmatrix[5],1);
            Arrays.fill(drawingmatrix[7],1);
            Arrays.fill(drawingmatrix[8],0);
            Arrays.fill(drawingmatrix[9],1);

            canvas.drawCircle(20,20,20,p);
            for(int i=0; i < sizeRow; i++) {
                for (int j = 0; j < sizeColm; j++)
                {
                    if(drawingmatrix[i][j] == 1)
                    {

                        rect.set(40*j,40*i,40*(j+1),40*(i+1));
                        canvas.drawRect(rect, p);
                    }
                }
            }

        }
    }

