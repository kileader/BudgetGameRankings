package com.kevinleader.bgr.entity;

import javax.persistence.*;

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
    private int id;

    @Column(name = "user_name")
    private String userName;

    private String email;

    private String password;

    private int settingsID;

    private int wishlistID;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param userName the user name
     * @param email    the email
     * @param password the password
     */
    public User(int id, String userName, String email, String password) {
        this.id = id;
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
     * Gets settings id.
     *
     * @return the settings id
     */
    public int getSettingsID() {
        return settingsID;
    }

    /**
     * Sets settings id.
     *
     * @param settingsID the settings id
     */
    public void setSettingsID(int settingsID) {
        this.settingsID = settingsID;
    }

    /**
     * Gets wishlist id.
     *
     * @return the wishlist id
     */
    public int getWishlistID() {
        return wishlistID;
    }

    /**
     * Sets wishlist id.
     *
     * @param wishlistID the wishlist id
     */
    public void setWishlistID(int wishlistID) {
        this.wishlistID = wishlistID;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", settingsID=" + settingsID +
                ", wishlistID=" + wishlistID +
                '}';
    }
}