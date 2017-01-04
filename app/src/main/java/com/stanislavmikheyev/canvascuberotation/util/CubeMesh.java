package com.stanislavmikheyev.canvascuberotation.util;

/**
 * Created by stani on 1/4/2017.
 */

public class CubeMesh {

    private float[][] edges;

    public CubeMesh() {
        edges = new float[12][];

        edges[0] = new float[]{0, 0, 0, 1, 0, 0};
        edges[1] = new float[]{1, 0, 0, 1, 1, 0};
        edges[2] = new float[]{1, 1, 0, 0, 1, 0};
        edges[3] = new float[]{0, 1, 0, 0, 0, 0};

        edges[4] = new float[]{0, 0, 0, 0, 0, 1};
        edges[5] = new float[]{1, 0, 0, 1, 0, 1};
        edges[6] = new float[]{1, 1, 0, 1, 1, 1};
        edges[7] = new float[]{0, 1, 0, 0, 1, 1};

        edges[8] = new float[]{0, 0, 1, 1, 0, 1};
        edges[9] = new float[]{1, 0, 1, 1, 1, 1};
        edges[10] = new float[]{1, 1, 1, 0, 1, 1};
        edges[11] = new float[]{0, 1, 1, 0, 0, 1};
    }

    public float[][] getEdges() {
        return edges;
    }

}
