package com.kevinleader.bgr.entity.ranker;

public class RankedGame {

    private String name;
    private double value;

    public RankedGame() {
    }

    public RankedGame(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "RankedGame{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}