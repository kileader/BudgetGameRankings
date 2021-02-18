package com.kevinleader.bgr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A javabean class to represent the settings for a custom ranking list.
 */
@Entity(name = "RankSetting")
@Table(name = "rank_setting")
public class RankSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "rank_name")
    private String rankName;

    @Column(name = "user_id")
    private int userId;

    private String platforms;

    private String genres;

    @Column(name = "release_span")
    private int releaseSpan;

    @Column(name = "low_price")
    private int lowPrice;

    @Column(name = "high_price")
    private int highPrice;

    /**
     * Instantiates a new Rank setting.
     */
    public RankSetting() {
    }

    /**
     * Instantiates a new Rank setting.
     *
     * @param id          the id
     * @param rankName    the user defined ranking name
     * @param userId      the user id
     * @param platforms   the gaming platforms
     * @param genres      the game genres
     * @param releaseSpan the time in seconds back from current for a game to be on the rankings
     * @param lowPrice    the lowest price to be ranked
     * @param highPrice   the highest price to be ranked
     */
    public RankSetting(int id, String rankName, int userId, String platforms, String genres, int releaseSpan, int lowPrice, int highPrice) {
        this.id = id;
        this.rankName = rankName;
        this.userId = userId;
        this.platforms = platforms;
        this.genres = genres;
        this.releaseSpan = releaseSpan;
        this.lowPrice = lowPrice;
        this.highPrice = highPrice;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets rank name.
     *
     * @return the rank name
     */
    public String getRankName() {
        return rankName;
    }

    /**
     * Sets rank name.
     *
     * @param rankName the rank name
     */
    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets platforms.
     *
     * @return the platforms
     */
    public String getPlatforms() {
        return platforms;
    }

    /**
     * Sets platforms.
     *
     * @param platforms the platforms
     */
    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    /**
     * Gets genres.
     *
     * @return the genres
     */
    public String getGenres() {
        return genres;
    }

    /**
     * Sets genres.
     *
     * @param genres the genres
     */
    public void setGenres(String genres) {
        this.genres = genres;
    }

    /**
     * Gets release span.
     *
     * @return the release span
     */
    public int getReleaseSpan() {
        return releaseSpan;
    }

    /**
     * Sets release span.
     *
     * @param releaseSpan the release span
     */
    public void setReleaseSpan(int releaseSpan) {
        this.releaseSpan = releaseSpan;
    }

    /**
     * Gets low price.
     *
     * @return the low price
     */
    public int getLowPrice() {
        return lowPrice;
    }

    /**
     * Sets low price.
     *
     * @param lowPrice the low price
     */
    public void setLowPrice(int lowPrice) {
        this.lowPrice = lowPrice;
    }

    /**
     * Gets high price.
     *
     * @return the high price
     */
    public int getHighPrice() {
        return highPrice;
    }

    /**
     * Sets high price.
     *
     * @param highPrice the high price
     */
    public void setHighPrice(int highPrice) {
        this.highPrice = highPrice;
    }

    @Override
    public String toString() {
        return "RankSetting{" +
                "id=" + id +
                ", rankName='" + rankName + '\'' +
                ", userId=" + userId +
                ", platforms='" + platforms + '\'' +
                ", genres='" + genres + '\'' +
                ", releaseSpan=" + releaseSpan +
                ", lowPrice=" + lowPrice +
                ", highPrice=" + highPrice +
                '}';
    }
}
