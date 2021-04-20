package com.kevinleader.bgr.entity.igdb;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	public void setGame(int game){
		this.game = game;
	}

	public int getGame(){
		return game;
	}

	public void setTrusted(boolean trusted){
		this.trusted = trusted;
	}

	public boolean isTrusted(){
		return trusted;
	}

	public void setChecksum(String checksum){
		this.checksum = checksum;
	}

	public String getChecksum(){
		return checksum;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategory(int category){
		this.category = category;
	}

	public int getCategory(){
		return category;
	}

	public void setUrl(String url){
		this.url = url;
	}

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