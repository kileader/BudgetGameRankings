package com.kevinleader.bgr.entity.steam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoriesItem{

	@JsonProperty("description")
	private String description;

	@JsonProperty("id")
	private int id;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"CategoriesItem{" + 
			"description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}