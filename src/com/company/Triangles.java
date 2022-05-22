package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Triangles implements Serializable {
    private List<EquilateralTriangle> triangles;

    public Triangles() {
        triangles = new ArrayList<>();
    }


    public void add(EquilateralTriangle triangle) {
        triangles.add(triangle);
    }

    public Triangles get_List_triangles_square_lager_average_square() {
        Triangles result = new Triangles();
        for (EquilateralTriangle triangle : triangles) {
            if (triangle.get_square() > average_square()) {
                result.add(triangle);
            }
        }
        return result;
    }

    private double average_square() {
        double result = 0;
        for (EquilateralTriangle triangle : triangles) {
            result += triangle.get_square();
        }
        return result / triangles.size();
    }

    @Override
    public String toString() {
        return "\n\n\nTriangles{" + triangles +
                '}';
    }
}