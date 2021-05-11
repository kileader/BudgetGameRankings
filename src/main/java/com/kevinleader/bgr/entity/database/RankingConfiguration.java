package com.kevinleader.bgr.entity.database;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Javabean to represent the settings for a custom ranking list.
 *
 * @author Kevin Leader
 */
@Entity(name = "RankingConfiguration")
@Table(name = "ranking_configuration")
public class RankingConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "ranking_configuration_user_id_fk"))
    private User user;

    @Column(name = "configuration_name")
    private String configurationName;

    private String platforms;

    private String genres;

    @Column(name = "release_span")
    private int releaseSpan;


    /**
     * Instantiates a new Ranking configuration.
     */
    public RankingConfiguration() {
    }

    /**
     * Instantiates a new Ranking configuration.
     *
     * @param user              the user
     * @param configurationName the configuration name
     * @param platforms         comma separated integers representing platforms on igdb.com
     * @param genres            comma separated integers representing genres on igdb.com
     * @param releaseSpan       the release span in seconds
     */
    public RankingConfiguration(User user, String configurationName, String platforms, String genres, int releaseSpan) {
        this.user = user;
        this.configurationName = configurationName;
        this.platforms = platforms;
        this.genres = genres;
        this.releaseSpan = releaseSpan;
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

    @Override
    public String toString() {
        return "RankingConfiguration{" +
                "id=" + id +
                ", user=" + user +
                ", configurationName='" + configurationName + '\'' +
                ", platforms='" + platforms + '\'' +
                ", genres='" + genres + '\'' +
                ", releaseSpan=" + releaseSpan +
                '}';
    }
}