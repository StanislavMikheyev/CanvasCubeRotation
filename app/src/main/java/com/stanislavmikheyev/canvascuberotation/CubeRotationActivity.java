package com.stanislavmikheyev.canvascuberotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CubeRotationActivity extends AppCompatActivity {

    private CubeRotationView cubeRotationView;
    private float rotationStep = 0.174533f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube_rotation);

        cubeRotationView = (CubeRotationView) this.findViewById(R.id.cubeRotation);
    }

    public void xPlusClickListener(View view) {
        cubeRotationView.setXRotation(cubeRotationView.getXRotation() + rotationStep);
        cubeRotationView.invalidate();
    }

    public void zPlusClickListener(View view) {
        cubeRotationView.setZRotation(cubeRotationView.getZRotation() + rotationStep);
        cubeRotationView.invalidate();
    }

    public void yPlusClickListener(View view) {
        cubeRotationView.setYRotation(cubeRotationView.getYRotation() + rotationStep);
        cubeRotationView.invalidate();
    }

    public void xMinusClickListener(View view) {
        cubeRotationView.setXRotation(cubeRotationView.getXRotation() - rotationStep);
        cubeRotationView.invalidate();
    }

    public void zMinusClickListener(View view) {
        cubeRotationView.setZRotation(cubeRotationView.getZRotation() - rotationStep);
        cubeRotationView.invalidate();
    }

    public void yMinusClickListener(View view) {
        cubeRotationView.setYRotation(cubeRotationView.getYRotation() - rotationStep);
        cubeRotationView.invalidate();
    }
}
