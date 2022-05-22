package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pyramids implements Serializable {
    public static List<RightPyramid> pyramids;

    public Pyramids() {
        pyramids = new ArrayList<>();
    }

    public  void add(RightPyramid pyramid) {
        pyramids.add(pyramid);
    }

    public RightPyramid get_pyramid_max_volume() {
        double max_volume = pyramids.get(0).get_volume();
        RightPyramid result = pyramids.get(0);
        for (RightPyramid pyramid : pyramids) {
            if (pyramid.get_volume() > max_volume) {
                max_volume = pyramid.get_volume();
                result = pyramid;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Pyramids{" + pyramids +
                '}';
    }
}
