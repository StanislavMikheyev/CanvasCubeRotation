package com.stanislavmikheyev.canvascuberotation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.stanislavmikheyev.canvascuberotation.util.MeshGenerator;
import com.stanislavmikheyev.canvascuberotation.util.Transformer;

public class CubeRotationView extends View {

    private Paint paint = new Paint();
    private float[][] cubeMesh = MeshGenerator.getCubeMesh();
    private Transformer transformer = new Transformer();

    public Transformer getTransformer() {
        return transformer;
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
        transformer.setUniversalScale(200);
        transformer.setXRotation(0.785398f);
        transformer.setYRotation(0.785398f);
        transformer.setZRotation(0.785398f);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);

        transformer.setXPosition(this.getWidth() / 2);
        transformer.setYPosition(this.getHeight() / 2);

        float[][] transformedMesh = transformer.applyTransformation(cubeMesh);

        for (float[] edge : transformedMesh) {
            canvas.drawLine(
                    edge[0], edge[1],
                    edge[3], edge[4],
                    paint);
        }
    }
}
