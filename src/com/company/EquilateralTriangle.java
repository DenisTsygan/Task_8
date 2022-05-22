package com.company;


import java.io.Serializable;

import static com.company.UtilityFormat.format_number;

public class EquilateralTriangle implements Serializable {

    private double side;

    public EquilateralTriangle(double side) {
        set_Side(side);
    }

    public double get_Side() {
        return side;
    }

    public void set_Side(double side) {
        this.side = side > 0 ? side : 0;
    }

    public double get_height() {
        return (side * Math.sqrt(3)) / 2;
    }

    public double get_bisector() {
        return (side * Math.sqrt(3)) / 2;
    }

    public double get_perimeter() {
        return side * 3;
    }

    public double get_square() {
        return (side * side * Math.sqrt(3)) / 4;
    }

    @Override
    public String toString() {

        return this.side != 0 ? "\nEquilateralTriangle {" +
                "side=" + format_number(side) + "; height=" + format_number(get_height()) + "; bisector="
                + format_number(get_bisector()) + "; perimeter" + format_number(get_perimeter())
                + "; square=" + format_number(this.get_square()) +
                '}' : "\nEquilateralTriangle { Side triangle=" + side + "}";
    }
}