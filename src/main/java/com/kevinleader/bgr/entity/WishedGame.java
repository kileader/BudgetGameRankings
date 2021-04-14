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

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id_fk"))
    private User user;

    @Column(name = "game_name")
    private String gameName;

    /**
     * id number used for the game on igdb.com
     */
    @Column(name = "igdb_game_id")
    private int igdbGameId;

    /**
     * id number for the game on steampowered.com
     */
    @Column(name = "steam_id")
    private int steamId;

    /**
     * Instantiates a new game on a user's wishlist.
     */
    public WishedGame() {
    }

    public WishedGame(User user, String gameName, int igdbGameId, int steamId) {
        this.user = user;
        this.gameName = gameName;
        this.igdbGameId = igdbGameId;
        this.steamId = steamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getIgdbGameId() {
        return igdbGameId;
    }

    public void setIgdbGameId(int igdbGameId) {
        this.igdbGameId = igdbGameId;
    }

    public int getSteamId() {
        return steamId;
    }

    public void setSteamId(int steamId) {
        this.steamId = steamId;
    }

    @Override
    public String toString() {
        return "WishedGame{" +
                "id=" + id +
                ", user=" + user +
                ", gameName='" + gameName + '\'' +
                ", igdbGameId=" + igdbGameId +
                ", steamId=" + steamId +
                '}';
    }
}