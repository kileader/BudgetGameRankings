package com.kevinleader.bgr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A javabean class to represent the settings for a custom ranking list.
 */
@Entity(name = "RankingConfiguration")
@Table(name = "ranking_configuration")
public class RankingConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "configuration_name")
    private String configurationName;

    private String platforms;

    private String genres;

    @Column(name = "release_span")
    private int releaseSpan;

    @Column(name = "lowest_price")
    private int lowestPrice;

    @Column(name = "highest_price")
    private int highestPrice;

    @ManyToOne
    private User user;

    /**
     * Instantiates a new Rank setting.
     */
    public RankingConfiguration() {
    }

    /**
     * Instantiates a new Ranking configuration.
     *
     * @param configurationName the configuration name
     * @param platforms         the platforms
     * @param genres            the genres
     * @param releaseSpan       the release span
     * @param lowestPrice       the lowest price
     * @param highestPrice      the highest price
     * @param user              the user
     */
    public RankingConfiguration(String configurationName, String platforms, String genres, int releaseSpan, int lowestPrice, int highestPrice, User user) {
        this.configurationName = configurationName;
        this.platforms = platforms;
        this.genres = genres;
        this.releaseSpan = releaseSpan;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
        this.user = user;
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
     * Gets configuration name.
     *
     * @return the configuration name
     */
    public String getConfigurationName() {
        return configurationName;
    }

    /**
     * Sets configuration name.
     *
     * @param configurationName the configuration name
     */
    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
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
     * Gets lowest price.
     *
     * @return the lowest price
     */
    public int getLowestPrice() {
        return lowestPrice;
    }

    /**
     * Sets lowest price.
     *
     * @param lowestPrice the lowest price
     */
    public void setLowestPrice(int lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    /**
     * Gets highest price.
     *
     * @return the highest price
     */
    public int getHighestPrice() {
        return highestPrice;
    }

    /**
     * Sets highest price.
     *
     * @param highestPrice the highest price
     */
    public void setHighestPrice(int highestPrice) {
        this.highestPrice = highestPrice;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RankingConfiguration{" +
                "id=" + id +
                ", configurationName='" + configurationName + '\'' +
                ", platforms='" + platforms + '\'' +
                ", genres='" + genres + '\'' +
                ", releaseSpan=" + releaseSpan +
                ", lowestPrice=" + lowestPrice +
                ", highestPrice=" + highestPrice +
                ", user=" + user +
                '}';
    }
}