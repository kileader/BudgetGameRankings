package com.kevinleader.bgr.entity.database;

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

    /**
     * Instantiates a new Wished game.
     *
     * @param user       the user
     * @param gameName   the game name
     * @param igdbGameId the igdb game id
     * @param steamId    the steam id
     */
    public WishedGame(User user, String gameName, int igdbGameId, int steamId) {
        this.user = user;
        this.gameName = gameName;
        this.igdbGameId = igdbGameId;
        this.steamId = steamId;
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
     * Gets game name.
     *
     * @return the game name
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * Sets game name.
     *
     * @param gameName the game name
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
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
     * Gets steam id.
     *
     * @return the steam id
     */
    public int getSteamId() {
        return steamId;
    }

    /**
     * Sets steam id.
     *
     * @param steamId the steam id
     */
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