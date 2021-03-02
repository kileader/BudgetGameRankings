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

    /**
     * id number used to refer to a specific videogame on igdb.com
     */
    @Column(name = "igdb_game_id")
    private int igdbGameId;

    @ManyToOne
    private User user;

    /**
     * Instantiates a new game on a user's wishlist.
     */
    public WishedGame() {
    }

    /**
     * Instantiates a new Wished game.
     *
     * @param igdbGameId the igdb game id
     * @param user       the user
     */
    public WishedGame(int igdbGameId, User user) {
        this.igdbGameId = igdbGameId;
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
     * Gets igdb game id.
     *
     * @return the igdb game id
     */
    public int getIgdbGameId() {
        return igdbGameId;
    }

    /**
     * Sets igdb game id.
     *
     * @param igdbGameId the igdb game id
     */
    public void setIgdbGameId(int igdbGameId) {
        this.igdbGameId = igdbGameId;
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
        return "WishedGame{" +
                "id=" + id +
                ", igdbGameId=" + igdbGameId +
                ", user=" + user +
                '}';
    }
}