package com.kevinleader.bgr.steampowered;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenresItem{

	@JsonProperty("description")
	private String description;

	@JsonProperty("id")
	private String id;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"GenresItem{" + 
			"description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}