package com.kevinleader.bgr.entity.igdb;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Javabean representing a video game's relevant properties as listed on igdb.com
 *
 * @author Kevin Leader
 */
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
	private List<Website> websites;

	/**
	 * Set summary.
	 *
	 * @param summary the summary
	 */
	public void setSummary(String summary){
		this.summary = summary;
	}

	/**
	 * Get summary string.
	 *
	 * @return the string
	 */
	public String getSummary(){
		return summary;
	}

	/**
	 * Set rating.
	 *
	 * @param rating the rating
	 */
	public void setRating(double rating){
		this.rating = rating;
	}

	/**
	 * Get rating double.
	 *
	 * @return the double
	 */
	public double getRating(){
		return rating;
	}

	/**
	 * Set aggregated rating count.
	 *
	 * @param aggregatedRatingCount the aggregated rating count
	 */
	public void setAggregatedRatingCount(int aggregatedRatingCount){
		this.aggregatedRatingCount = aggregatedRatingCount;
	}

	/**
	 * Get aggregated rating count int.
	 *
	 * @return the int
	 */
	public int getAggregatedRatingCount(){
		return aggregatedRatingCount;
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

	/**
	 * Set platforms.
	 *
	 * @param platforms the platforms
	 */
	public void setPlatforms(List<Integer> platforms){
		this.platforms = platforms;
	}

	/**
	 * Get platforms list.
	 *
	 * @return the list
	 */
	public List<Integer> getPlatforms(){
		return platforms;
	}

	/**
	 * Set rating count.
	 *
	 * @param ratingCount the rating count
	 */
	public void setRatingCount(int ratingCount){
		this.ratingCount = ratingCount;
	}

	/**
	 * Get rating count int.
	 *
	 * @return the int
	 */
	public int getRatingCount(){
		return ratingCount;
	}

	/**
	 * Set cover.
	 *
	 * @param cover the cover
	 */
	public void setCover(int cover){
		this.cover = cover;
	}

	/**
	 * Get cover int.
	 *
	 * @return the int
	 */
	public int getCover(){
		return cover;
	}

	/**
	 * Set first release date.
	 *
	 * @param firstReleaseDate the first release date
	 */
	public void setFirstReleaseDate(int firstReleaseDate){
		this.firstReleaseDate = firstReleaseDate;
	}

	/**
	 * Get first release date int.
	 *
	 * @return the int
	 */
	public int getFirstReleaseDate(){
		return firstReleaseDate;
	}

	/**
	 * Set genres.
	 *
	 * @param genres the genres
	 */
	public void setGenres(List<Integer> genres){
		this.genres = genres;
	}

	/**
	 * Get genres list.
	 *
	 * @return the list
	 */
	public List<Integer> getGenres(){
		return genres;
	}

	/**
	 * Set storyline.
	 *
	 * @param storyline the storyline
	 */
	public void setStoryline(String storyline){
		this.storyline = storyline;
	}

	/**
	 * Get storyline string.
	 *
	 * @return the string
	 */
	public String getStoryline(){
		return storyline;
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

	/**
	 * Set total rating count.
	 *
	 * @param totalRatingCount the total rating count
	 */
	public void setTotalRatingCount(int totalRatingCount){
		this.totalRatingCount = totalRatingCount;
	}

	/**
	 * Get total rating count int.
	 *
	 * @return the int
	 */
	public int getTotalRatingCount(){
		return totalRatingCount;
	}

	/**
	 * Set aggregated rating.
	 *
	 * @param aggregatedRating the aggregated rating
	 */
	public void setAggregatedRating(double aggregatedRating){
		this.aggregatedRating = aggregatedRating;
	}

	/**
	 * Get aggregated rating double.
	 *
	 * @return the double
	 */
	public double getAggregatedRating(){
		return aggregatedRating;
	}

	/**
	 * Set total rating.
	 *
	 * @param totalRating the total rating
	 */
	public void setTotalRating(double totalRating){
		this.totalRating = totalRating;
	}

	/**
	 * Get total rating double.
	 *
	 * @return the double
	 */
	public double getTotalRating(){
		return totalRating;
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
	 * Gets websites.
	 *
	 * @return the websites
	 */
	public List<Website> getWebsites() {
		return websites;
	}

	/**
	 * Sets websites.
	 *
	 * @param websites the websites
	 */
	public void setWebsites(List<Website> websites) {
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