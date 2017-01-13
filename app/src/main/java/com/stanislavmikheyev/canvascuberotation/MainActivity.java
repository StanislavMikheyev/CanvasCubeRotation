package com.stanislavmikheyev.canvascuberotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.stanislavmikheyev.canvascuberotation.util.Transformer;

public class MainActivity extends AppCompatActivity {

    private CubeRotationView cubeRotationView;
    private Transformer cubeRotationViewTransformer;
    private static float SCALE_STEP = 10;
    private EditText rotationStepText;
    private float rotationStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cubeRotationView = (CubeRotationView) this.findViewById(R.id.cubeRotation);
        cubeRotationViewTransformer = cubeRotationView.getTransformer();
        rotationStepText = (EditText) findViewById(R.id.rotationStep);
    }

    public void xPlusClickListener(View view) {
        updateRotationStep();
        cubeRotationViewTransformer.setXRotation(cubeRotationViewTransformer.getXRotation() + rotationStep);
        cubeRotationView.invalidate();
    }

    private void updateRotationStep() {
        rotationStep = (float) Math.toRadians(Float.valueOf(rotationStepText.getText().toString()));
    }

    public void zPlusClickListener(View view) {
        updateRotationStep();
        cubeRotationViewTransformer.setZRotation(cubeRotationViewTransformer.getZRotation() + rotationStep);
        cubeRotationView.invalidate();
    }

    public void yPlusClickListener(View view) {
        updateRotationStep();
        cubeRotationViewTransformer.setYRotation(cubeRotationViewTransformer.getYRotation() + rotationStep);
        cubeRotationView.invalidate();
    }

    public void xMinusClickListener(View view) {
        updateRotationStep();
        cubeRotationViewTransformer.setXRotation(cubeRotationViewTransformer.getXRotation() - rotationStep);
        cubeRotationView.invalidate();
    }

    public void zMinusClickListener(View view) {
        updateRotationStep();
        cubeRotationViewTransformer.setZRotation(cubeRotationViewTransformer.getZRotation() - rotationStep);
        cubeRotationView.invalidate();
    }

    public void yMinusClickListener(View view) {
        updateRotationStep();
        cubeRotationViewTransformer.setYRotation(cubeRotationViewTransformer.getYRotation() - rotationStep);
        cubeRotationView.invalidate();
    }

    public void zoomInClickListener(View view) {
        cubeRotationViewTransformer.setXScale(cubeRotationViewTransformer.getXScale() + SCALE_STEP);
        cubeRotationViewTransformer.setYScale(cubeRotationViewTransformer.getYScale() + SCALE_STEP);
        cubeRotationViewTransformer.setZScale(cubeRotationViewTransformer.getZScale() + SCALE_STEP);
        cubeRotationView.invalidate();
    }

    public void zoomOutClickListener(View view) {
        cubeRotationViewTransformer.setXScale(cubeRotationViewTransformer.getXScale() - SCALE_STEP);
        cubeRotationViewTransformer.setYScale(cubeRotationViewTransformer.getYScale() - SCALE_STEP);
        cubeRotationViewTransformer.setZScale(cubeRotationViewTransformer.getZScale() - SCALE_STEP);
        cubeRotationView.invalidate();
    }

    public void defaultPositionClickListener(View view) {
        cubeRotationViewTransformer.setUniversalScale(150);
        cubeRotationViewTransformer.setXRotation(0);
        cubeRotationViewTransformer.setYRotation(0);
        cubeRotationViewTransformer.setZRotation(0);
        cubeRotationView.invalidate();
    }
}
