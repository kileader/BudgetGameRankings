package com.kevinleader.bgr.entity.steam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Platforms{

	@JsonProperty("linux")
	private boolean linux;

	@JsonProperty("windows")
	private boolean windows;

	@JsonProperty("mac")
	private boolean mac;

	public void setLinux(boolean linux){
		this.linux = linux;
	}

	public boolean isLinux(){
		return linux;
	}

	public void setWindows(boolean windows){
		this.windows = windows;
	}

	public boolean isWindows(){
		return windows;
	}

	public void setMac(boolean mac){
		this.mac = mac;
	}

	public boolean isMac(){
		return mac;
	}

	@Override
 	public String toString(){
		return 
			"Platforms{" + 
			"linux = '" + linux + '\'' + 
			",windows = '" + windows + '\'' + 
			",mac = '" + mac + '\'' + 
			"}";
		}
}