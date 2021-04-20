package com.kevinleader.bgr.entity.igdb;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Game{

	@JsonProperty("summary")
	private String summary;

	@JsonProperty("rating")
	private double rating;

	@JsonProperty("aggregated_rating_count")
	private int aggregatedRatingCount;

	@JsonProperty("url")
	private String url;

	@JsonProperty("platforms")
	private List<Integer> platforms;

	@JsonProperty("rating_count")
	private int ratingCount;

	@JsonProperty("cover")
	private int cover;

	@JsonProperty("first_release_date")
	private int firstReleaseDate;

	@JsonProperty("genres")
	private List<Integer> genres;

	@JsonProperty("storyline")
	private String storyline;

	@JsonProperty("name")
	private String name;

	@JsonProperty("total_rating_count")
	private int totalRatingCount;

	@JsonProperty("aggregated_rating")
	private double aggregatedRating;

	@JsonProperty("total_rating")
	private double totalRating;

	@JsonProperty("id")
	private int id;

	@JsonProperty("websites")
	private List<Integer> websites;

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setRating(double rating){
		this.rating = rating;
	}

	public double getRating(){
		return rating;
	}

	public void setAggregatedRatingCount(int aggregatedRatingCount){
		this.aggregatedRatingCount = aggregatedRatingCount;
	}

	public int getAggregatedRatingCount(){
		return aggregatedRatingCount;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setPlatforms(List<Integer> platforms){
		this.platforms = platforms;
	}

	public List<Integer> getPlatforms(){
		return platforms;
	}

	public void setRatingCount(int ratingCount){
		this.ratingCount = ratingCount;
	}

	public int getRatingCount(){
		return ratingCount;
	}

	public void setCover(int cover){
		this.cover = cover;
	}

	public int getCover(){
		return cover;
	}

	public void setFirstReleaseDate(int firstReleaseDate){
		this.firstReleaseDate = firstReleaseDate;
	}

	public int getFirstReleaseDate(){
		return firstReleaseDate;
	}

	public void setGenres(List<Integer> genres){
		this.genres = genres;
	}

	public List<Integer> getGenres(){
		return genres;
	}

	public void setStoryline(String storyline){
		this.storyline = storyline;
	}

	public String getStoryline(){
		return storyline;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setTotalRatingCount(int totalRatingCount){
		this.totalRatingCount = totalRatingCount;
	}

	public int getTotalRatingCount(){
		return totalRatingCount;
	}

	public void setAggregatedRating(double aggregatedRating){
		this.aggregatedRating = aggregatedRating;
	}

	public double getAggregatedRating(){
		return aggregatedRating;
	}

	public void setTotalRating(double totalRating){
		this.totalRating = totalRating;
	}

	public double getTotalRating(){
		return totalRating;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public List<Integer> getWebsites() {
		return websites;
	}

	public void setWebsites(List<Integer> websites) {
		this.websites = websites;
	}

	@Override
 	public String toString(){
		return 
			"Game{" + 
			"summary = '" + summary + '\'' + 
			",rating = '" + rating + '\'' + 
			",aggregated_rating_count = '" + aggregatedRatingCount + '\'' + 
			",url = '" + url + '\'' + 
			",platforms = '" + platforms + '\'' + 
			",rating_count = '" + ratingCount + '\'' + 
			",cover = '" + cover + '\'' +
			",first_release_date = '" + firstReleaseDate + '\'' + 
			",genres = '" + genres + '\'' + 
			",storyline = '" + storyline + '\'' + 
			",name = '" + name + '\'' + 
			",total_rating_count = '" + totalRatingCount + '\'' + 
			",aggregated_rating = '" + aggregatedRating + '\'' + 
			",total_rating = '" + totalRating + '\'' + 
			",id = '" + id + '\'' +
			",websites = '" + websites + '\'' +
			"}";
		}
}