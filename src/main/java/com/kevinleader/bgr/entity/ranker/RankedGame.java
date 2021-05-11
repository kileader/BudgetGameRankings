package com.kevinleader.bgr.entity.ranker;

import com.kevinleader.bgr.entity.igdb.Website;

import java.util.List;

/**
 * Javabean representing information used in comparing video games on a budget game ranking list.
 *
 * @author Kevin Leader
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

    /**
     * Instantiates a new Ranked game.
     *
     * @param name     the name of the video game
     * @param value    the value (rating / price)
     * @param rating   the total rating from igdb.com
     * @param price    the game's price in USD
     * @param url      the igdb.com url
     * @param websites list of website objects for the game
     * @param igdbId   the igdb id
     */
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

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets websites.
     *
     * @return the websites
     */
    public List<Website> getWebsites() {
        return websites;
    }

    /**
     * Sets websites.
     *
     * @param websites the websites
     */
    public void setWebsites(List<Website> websites) {
        this.websites = websites;
    }

    /**
     * Gets igdb id.
     *
     * @return the igdb id
     */
    public int getIgdbId() {
        return igdbId;
    }

    /**
     * Sets igdb id.
     *
     * @param igdbId the igdb id
     */
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