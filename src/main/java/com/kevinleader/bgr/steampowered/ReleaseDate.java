package com.kevinleader.bgr.steampowered;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReleaseDate{

	@JsonProperty("coming_soon")
	private boolean comingSoon;

	@JsonProperty("date")
	private String date;

	public void setComingSoon(boolean comingSoon){
		this.comingSoon = comingSoon;
	}

	public boolean isComingSoon(){
		return comingSoon;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	@Override
 	public String toString(){
		return 
			"ReleaseDate{" + 
			"coming_soon = '" + comingSoon + '\'' + 
			",date = '" + date + '\'' + 
			"}";
		}
}