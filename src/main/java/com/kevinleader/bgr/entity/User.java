package com.kevinleader.bgr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A javabean class to represent a user.
 *
 * @author Kevin Leader
 */
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "user_name")
    private String userName;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<WishedGame> wishedGames = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RankingConfiguration> rankingConfigurations = new HashSet<>();

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private Set<Role> roles = new HashSet<>();

    /**
     * Instantiates a new User with no parameters.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userName the user name
     * @param email    the email
     * @param password the password
     */
    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
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
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets wished games.
     *
     * @return the wished games
     */
    public Set<WishedGame> getWishedGames() {
        return wishedGames;
    }

    /**
     * Sets wished games.
     *
     * @param wishedGames the wished games
     */
    public void setWishedGames(Set<WishedGame> wishedGames) {
        this.wishedGames = wishedGames;
    }

    /**
     * Gets ranking configurations.
     *
     * @return the ranking configurations
     */
    public Set<RankingConfiguration> getRankingConfigurations() {
        return rankingConfigurations;
    }

    /**
     * Sets ranking configurations.
     *
     * @param rankingConfigurations the ranking configurations
     */
    public void setRankingConfigurations(Set<RankingConfiguration> rankingConfigurations) {
        this.rankingConfigurations = rankingConfigurations;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

    /**
     * Add wished game.
     *
     * @param wishedGame the wished game
     */
    public void addWishedGame(WishedGame wishedGame) {
        wishedGames.add(wishedGame);
        wishedGame.setUser(this);
    }

    /**
     * Remove wished game.
     *
     * @param wishedGame the wished game
     */
    public void removeWishedGame(WishedGame wishedGame) {
        wishedGames.remove(wishedGame);
        wishedGame.setUser(null);
    }

    /**
     * Add ranking configuration.
     *
     * @param rankingConfiguration the ranking configuration
     */
    public void addRankingConfiguration(RankingConfiguration rankingConfiguration) {
        rankingConfigurations.add(rankingConfiguration);
        rankingConfiguration.setUser(this);
    }

    /**
     * Remove ranking configuration.
     *
     * @param rankingConfiguration the ranking configuration
     */
    public void removeRankingConfiguration(RankingConfiguration rankingConfiguration) {
        rankingConfigurations.remove(rankingConfiguration);
        rankingConfiguration.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}