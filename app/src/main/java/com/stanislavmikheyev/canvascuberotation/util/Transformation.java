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

        rotationMatrix[0][0] = cosX * cosZ;
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

    private float[] applyRotationMatrixToEdge(float[] edge) {
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

    public float[][] applyTransformation(float[][] mesh) {

        float[][] transformedMesh = new float[mesh.length][];

        for (int i = 0; i < mesh.length; i++) {

            transformedMesh[i] = mesh[i];

            //Rotation
            transformedMesh[i] = applyRotationMatrixToEdge(transformedMesh[i]);

            //Scaling
            transformedMesh[i][0] *= xScale;
            transformedMesh[i][1] *= yScale;
            transformedMesh[i][2] *= zScale;
            transformedMesh[i][3] *= xScale;
            transformedMesh[i][4] *= yScale;
            transformedMesh[i][5] *= zScale;

            //Translation
            transformedMesh[i][0] += xPosition;
            transformedMesh[i][1] += yPosition;
            transformedMesh[i][2] += zPosition;
            transformedMesh[i][3] += xPosition;
            transformedMesh[i][4] += yPosition;
            transformedMesh[i][5] += zPosition;
        }
        return transformedMesh;
    }

}
