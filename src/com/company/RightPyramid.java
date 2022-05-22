package com.company;


import java.io.Serializable;

import static com.company.UtilityFormat.format_number;

public class RightPyramid extends EquilateralTriangle implements Serializable {
    private double apothem;

    public RightPyramid(double side, double apothem) {
        super(side);
        set_Apothem(apothem);
    }
    public double get_Apothem() {
        return apothem;
    }

    public void set_Apothem(double apothem) {
        this.apothem = apothem > 0 ? apothem : 0;
    }

    public double get_volume() {
        return (super.get_square() * this.apothem) / 3;
    }

    @Override
    public double get_square() {
        return super.get_square() + (3 * super.get_Side() * this.apothem) / 2;
    }

    @Override
    public String toString() {
        String result = super.get_Side() != 0 && this.apothem != 0 ? "\nRightPyramid ({" + "volume=" + format_number(get_volume()) + "; square" + format_number(get_square()) + "; apothem" + format_number(apothem) + "}"
                : "\nRightPyramid {side=" + get_Side() + "; apothem=" + this.apothem + "(side or apothem=0)}";
        return result + super.toString() + ")";
    }
}