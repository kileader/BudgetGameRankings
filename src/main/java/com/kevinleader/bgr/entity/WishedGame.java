package com.kevinleader.bgr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A javabean class to represent a game on a wishlist.
 *
 * @author Kevin Leader
 */
@Entity(name = "WishedGame")
@Table(name = "wished_game")
public class WishedGame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "igdb_id")
    private int igdbId;

    @Column(name = "user_id")
    private int userId;

    /**
     * Instantiates a new Wished game.
     */
    public WishedGame() {
    }

    /**
     * Instantiates a new Wished game.
     *
     * @param id     the id
     * @param igdbId the igdb.com game id
     * @param userId the user id
     */
    public WishedGame(int id, int igdbId, int userId) {
        this.id = id;
        this.igdbId = igdbId;
        this.userId = userId;
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

    @Override
    public String toString() {
        return "WishedGame{" +
                "id=" + id +
                ", igdbId=" + igdbId +
                ", userId=" + userId +
                '}';
    }
}