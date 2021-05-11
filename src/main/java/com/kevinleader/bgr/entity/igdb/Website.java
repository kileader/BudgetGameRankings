package com.kevinleader.bgr.entity.igdb;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Javabean for a game's website's info on igdb.com
 *
 * @author Kevin Leader
 */
public class Website {

	@JsonProperty("game")
	private int game;

	@JsonProperty("trusted")
	private boolean trusted;

	@JsonProperty("checksum")
	private String checksum;

	@JsonProperty("id")
	private int id;

	@JsonProperty("category")
	private int category;

	@JsonProperty("url")
	private String url;

	/**
	 * Set game.
	 *
	 * @param game the game
	 */
	public void setGame(int game){
		this.game = game;
	}

	/**
	 * Get game int.
	 *
	 * @return the int
	 */
	public int getGame(){
		return game;
	}

	/**
	 * Set trusted.
	 *
	 * @param trusted the trusted
	 */
	public void setTrusted(boolean trusted){
		this.trusted = trusted;
	}

	/**
	 * Is trusted boolean.
	 *
	 * @return the boolean
	 */
	public boolean isTrusted(){
		return trusted;
	}

	/**
	 * Set checksum.
	 *
	 * @param checksum the checksum
	 */
	public void setChecksum(String checksum){
		this.checksum = checksum;
	}

	/**
	 * Get checksum string.
	 *
	 * @return the string
	 */
	public String getChecksum(){
		return checksum;
	}

	/**
	 * Set id.
	 *
	 * @param id the id
	 */
	public void setId(int id){
		this.id = id;
	}

	/**
	 * Get id int.
	 *
	 * @return the int
	 */
	public int getId(){
		return id;
	}

	/**
	 * Set category.
	 *
	 * @param category the category
	 */
	public void setCategory(int category){
		this.category = category;
	}

	/**
	 * Get category int.
	 *
	 * @return the int
	 */
	public int getCategory(){
		return category;
	}

	/**
	 * Set url.
	 *
	 * @param url the url
	 */
	public void setUrl(String url){
		this.url = url;
	}

	/**
	 * Get url string.
	 *
	 * @return the string
	 */
	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return
			"Website{" +
			"game = '" + game + '\'' +
			",trusted = '" + trusted + '\'' +
			",checksum = '" + checksum + '\'' +
			",id = '" + id + '\'' +
			",category = '" + category + '\'' +
			",url = '" + url + '\'' +
			"}";
		}
}