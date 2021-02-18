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

    public RankingConfiguration(String configurationName, String platforms, String genres, int releaseSpan, int lowestPrice, int highestPrice, User user) {
        this.configurationName = configurationName;
        this.platforms = platforms;
        this.genres = genres;
        this.releaseSpan = releaseSpan;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConfigurationName() {
        return configurationName;
    }

    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getReleaseSpan() {
        return releaseSpan;
    }

    public void setReleaseSpan(int releaseSpan) {
        this.releaseSpan = releaseSpan;
    }

    public int getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(int lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public int getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(int highestPrice) {
        this.highestPrice = highestPrice;
    }

    public User getUser() {
        return user;
    }

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