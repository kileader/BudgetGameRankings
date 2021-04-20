package com.kevinleader.bgr.entity.ranker;

/**
 * The type Ranked game.
 */
public class RankedGame {

    private String name;
    private double value;

    /**
     * Instantiates a new Ranked game.
     */
    public RankedGame() {
    }

    /**
     * Instantiates a new Ranked game.
     *
     * @param name  the name
     * @param value the value
     */
    public RankedGame(String name, double value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
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