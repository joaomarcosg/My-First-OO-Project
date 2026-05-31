package com.joao.firstooproject.constants;

public enum Genre {
    DRAMA(15),
    SUSPENSE(10),
    ROMANCE(5);

    private final double factor;

    Genre(double factor){this.factor = factor / 100;}

    public double getFactor(){return factor;}
}
