package com.stanislavmikheyev.canvascuberotation.util;


public class Transformation {

    private float xScale = 1;
    private float yScale = 1;
    private float zScale = 1;

    private float xPosition = 0;
    private float yPosition = 0;
    private float zPosition = 0;

    private float xRotation = 0;
    private float yRotation = 0;
    private float zRotation = 0;

    public void setScale(float x, float y, float z) {
        xScale = x;
        yScale = y;
        zScale = z;
    }

    public void setUniversalScale(float scale) {
        xScale = scale;
        yScale = scale;
        zScale = scale;
    }

    public void setPosition(float x, float y, float z) {
        xPosition = x;
        yPosition = y;
        zPosition = z;
    }

    public void setRotation(float x, float y, float z) {
        xRotation = x;
        yRotation = y;
        zRotation = z;
    }

    public float getXScale() {
        return xScale;
    }

    public void setXScale(float xScale) {
        this.xScale = xScale;
    }

    public float getYScale() {
        return yScale;
    }

    public void setYScale(float yScale) {
        this.yScale = yScale;
    }

    public float getZScale() {
        return zScale;
    }

    public void setZScale(float zScale) {
        this.zScale = zScale;
    }

    public float getXPosition() {
        return xPosition;
    }

    public void setXPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public float getYPosition() {
        return yPosition;
    }

    public void setYPosition(float yPosition) {
        this.yPosition = yPosition;
    }

    public float getZPosition() {
        return zPosition;
    }

    public void setZPosition(float zPosition) {
        this.zPosition = zPosition;
    }

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

    private float[][] calculateRotationMatrix() {

        float sinX = (float) Math.sin(xRotation);
        float sinY = (float) Math.sin(yRotation);
        float sinZ = (float) Math.sin(zRotation);
        float cosX = (float) Math.cos(xRotation);
        float cosY = (float) Math.cos(yRotation);
        float cosZ = (float) Math.cos(zRotation);

        float[][] rotationMatrix = new float[3][3];

        rotationMatrix[0][0] = cosY * cosZ;
        rotationMatrix[0][1] = -cosY * sinZ;
        rotationMatrix[0][2] = sinY;
        rotationMatrix[1][0] = cosX * sinZ + sinX * sinY * cosZ;
        rotationMatrix[1][1] = cosX * cosZ - sinX * sinY * sinZ;
        rotationMatrix[1][2] = -sinX * cosY;
        rotationMatrix[2][0] = sinX * sinZ - cosX * sinY * cosZ;
        rotationMatrix[2][1] = sinX * cosZ + cosX * sinY * sinZ;
        rotationMatrix[2][2] = cosX * cosY;

        return rotationMatrix;
    }

    private float[] applyRotation(float[] edge) {
        float[][] rm = calculateRotationMatrix();

        float[] rotatedEdge = new float[6];

        rotatedEdge[0] = rm[0][0] * edge[0] + rm[0][1] * edge[1] + rm[0][2] * edge[2];
        rotatedEdge[1] = rm[1][0] * edge[0] + rm[1][1] * edge[1] + rm[1][2] * edge[2];
        rotatedEdge[2] = rm[2][0] * edge[0] + rm[2][1] * edge[1] + rm[2][2] * edge[2];

        rotatedEdge[3] = rm[0][0] * edge[3] + rm[0][1] * edge[4] + rm[0][2] * edge[5];
        rotatedEdge[4] = rm[1][0] * edge[3] + rm[1][1] * edge[4] + rm[1][2] * edge[5];
        rotatedEdge[5] = rm[2][0] * edge[3] + rm[2][1] * edge[4] + rm[2][2] * edge[5];

        return rotatedEdge;
    }

    private float[] applyScale(float[] edge) {
        float[] scaledEdge = new float[6];

        scaledEdge[0] = edge[0] * xScale;
        scaledEdge[1] = edge[1] * yScale;
        scaledEdge[2] = edge[2] * zScale;
        scaledEdge[3] = edge[3] * xScale;
        scaledEdge[4] = edge[4] * yScale;
        scaledEdge[5] = edge[5] * zScale;

        return scaledEdge;
    }

    private float[] applyTranslation(float[] edge) {
        float[] translatedEdge = new float[6];

        translatedEdge[0] = edge[0] + xPosition;
        translatedEdge[1] = edge[1] + yPosition;
        translatedEdge[2] = edge[2] + zPosition;
        translatedEdge[3] = edge[3] + xPosition;
        translatedEdge[4] = edge[4] + yPosition;
        translatedEdge[5] = edge[5] + zPosition;

        return translatedEdge;
    }

    public float[][] applyTransformation(float[][] mesh) {

        float[][] transformedMesh = new float[mesh.length][];

        for (int i = 0; i < mesh.length; i++) {
            //Apply transformations
            transformedMesh[i] = mesh[i];
            transformedMesh[i] = applyRotation(transformedMesh[i]);
            transformedMesh[i] = applyScale(transformedMesh[i]);
            transformedMesh[i] = applyTranslation(transformedMesh[i]);
        }
        return transformedMesh;
    }

}
