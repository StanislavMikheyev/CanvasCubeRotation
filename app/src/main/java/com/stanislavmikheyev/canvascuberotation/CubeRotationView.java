package com.stanislavmikheyev.canvascuberotation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.stanislavmikheyev.canvascuberotation.util.MeshGenerator;
import com.stanislavmikheyev.canvascuberotation.util.Transformation;

public class CubeRotationView extends View {

    private Paint paint = new Paint();
    private float[][] cubeMesh = MeshGenerator.getCubeMesh();
    private Transformation transformation = new Transformation();

    private float xRotation = 0;
    private float yRotation = 0;
    private float zRotation = 0;

    public float getXRotation() {
        return xRotation;
    }

    public void setXRotation(float xRotation) {
        this.xRotation = xRotation;
    }

    public float getYRotation() {
        return yRotation;
    }

    public void setYRotation(float yRotation) {
        this.yRotation = yRotation;
    }

    public float getZRotation() {
        return zRotation;
    }

    public void setZRotation(float zRotation) {
        this.zRotation = zRotation;
    }

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
        transformation.setXPosition(200);
        transformation.setYPosition(200);
        transformation.setXRotation(xRotation);
        transformation.setYRotation(yRotation);
        transformation.setZRotation(zRotation);

        float[][] transformedMesh = transformation.applyTransformation(cubeMesh);

        for (float[] edge : transformedMesh) {
            canvas.drawLine(
                    edge[0], edge[1],
                    edge[3], edge[4],
                    paint);
        }
    }
}
