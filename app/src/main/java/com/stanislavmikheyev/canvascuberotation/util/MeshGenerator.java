package com.stanislavmikheyev.canvascuberotation.util;

public class MeshGenerator {

    public static float[][] getCubeMesh() {
        float[][] edges = new float[12][];

        edges[0] = new float[]{-0.5f, -0.5f, -0.5f, 0.5f, -0.5f, -0.5f};
        edges[1] = new float[]{0.5f, -0.5f, -0.5f, 0.5f, 0.5f, -0.5f};
        edges[2] = new float[]{0.5f, 0.5f, -0.5f, -0.5f, 0.5f, -0.5f};
        edges[3] = new float[]{-0.5f, 0.5f, -0.5f, -0.5f, -0.5f, -0.5f};

        edges[4] = new float[]{-0.5f, -0.5f, -0.5f, -0.5f, -0.5f, 0.5f};
        edges[5] = new float[]{0.5f, -0.5f, -0.5f, 0.5f, -0.5f, 0.5f};
        edges[6] = new float[]{0.5f, 0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        edges[7] = new float[]{-0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f};

        edges[8] = new float[]{-0.5f, -0.5f, 0.5f, 0.5f, -0.5f, 0.5f};
        edges[9] = new float[]{0.5f, -0.5f, 0.5f, 0.5f, 0.5f, 0.5f};
        edges[10] = new float[]{0.5f, 0.5f, 0.5f, -0.5f, 0.5f, 0.5f};
        edges[11] = new float[]{-0.5f, 0.5f, 0.5f, -0.5f, -0.5f, 0.5f};

        return edges;
    }

}
