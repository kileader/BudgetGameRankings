package com.kevinleader.bgr.steampowered;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAppListItem {

	@JsonProperty("appid")
	private int appid;

	@JsonProperty("name")
	private String name;

	public void setAppid(int appid){
		this.appid = appid;
	}

	public int getAppid(){
		return appid;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"ResponseItem{" + 
			"appid = '" + appid + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}