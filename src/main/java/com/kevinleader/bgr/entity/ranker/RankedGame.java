package com.kevinleader.bgr.entity.ranker;

import com.kevinleader.bgr.entity.igdb.Website;

import java.util.List;

/**
 * The type Ranked game.
 */
public class RankedGame {

    private String name;
    private double value;
    private double rating;
    private double price;
    private String url;
    private List<Website> websites;
    private int igdbId;

    /**
     * Instantiates a new Ranked game.
     */
    public RankedGame() {
    }

    public RankedGame(String name, double value, double rating, double price,
                      String url, List<Website> websites, int igdbId) {
        this.name = name;
        this.value = value;
        this.rating = rating;
        this.price = price;
        this.url = url;
        this.websites = websites;
        this.igdbId = igdbId;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Website> getWebsites() {
        return websites;
    }

    public void setWebsites(List<Website> websites) {
        this.websites = websites;
    }

    public int getIgdbId() {
        return igdbId;
    }

    public void setIgdbId(int igdbId) {
        this.igdbId = igdbId;
    }

    @Override
    public String toString() {
        return "RankedGame{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", rating=" + rating +
                ", price=" + price +
                ", url='" + url + '\'' +
                ", websites=" + websites +
                ", igdbId=" + igdbId +
                '}';
    }
}