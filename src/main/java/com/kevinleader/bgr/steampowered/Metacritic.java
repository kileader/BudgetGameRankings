package com.kevinleader.bgr.steampowered;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metacritic{

	@JsonProperty("score")
	private int score;

	@JsonProperty("url")
	private String url;

	public void setScore(int score){
		this.score = score;
	}

	public int getScore(){
		return score;
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
			"Metacritic{" + 
			"score = '" + score + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}