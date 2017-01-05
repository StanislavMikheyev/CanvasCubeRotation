package com.stanislavmikheyev.canvascuberotation.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CubeRotationView extends View {

    private Paint paint = new Paint();
    private float[][] cubeMesh = MeshGenerator.getCubeMesh();
    private Transformation transformation = new Transformation();

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
        paint.setAntiAlias(true);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.CYAN);
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);

        transformation.setUniversalScale(150);
        transformation.setXPosition(100);
        transformation.setYPosition(100);
        transformation.setXRotation(0.785398f);
        transformation.setYRotation(0.785398f);
        transformation.setZRotation(0.785398f);

        for (float[] edge : transformation.applyTransformation(cubeMesh)) {
            canvas.drawLine(
                    edge[0], edge[1],
                    edge[3], edge[4],
                    paint);
        }
    }
}
