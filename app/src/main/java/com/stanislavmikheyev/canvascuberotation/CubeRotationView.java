package com.stanislavmikheyev.canvascuberotation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.stanislavmikheyev.canvascuberotation.util.CubeMesh;

/**
 * Created by stani on 1/4/2017.
 */

public class CubeRotationView extends View {

    private Paint paint = new Paint();
    private CubeMesh cubeMesh = new CubeMesh();
    private float scale = 700;

    public CubeRotationView(Context context) {
        super(context);
        init(null, 0);
    }

    public CubeRotationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CubeRotationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.CYAN);
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);
        for (float[] edge : cubeMesh.getEdges()) {
            canvas.drawLine(
                    edge[0] * scale, edge[1] * scale,
                    edge[3] * scale, edge[4] * scale,
                    paint);
        }
    }
}
