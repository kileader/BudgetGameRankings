package com.kevinleader.bgr.entity.steam;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type App list item.
 */
public class AppListItem {

	@JsonProperty("appid")
	private int appid;

	@JsonProperty("name")
	private String name;

	/**
	 * Set appid.
	 *
	 * @param appid the appid
	 */
	public void setAppid(int appid){
		this.appid = appid;
	}

	/**
	 * Get appid int.
	 *
	 * @return the int
	 */
	public int getAppid(){
		return appid;
	}

	/**
	 * Set name.
	 *
	 * @param name the name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Get name string.
	 *
	 * @return the string
	 */
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