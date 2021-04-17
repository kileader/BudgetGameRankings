package com.kevinleader.bgr.entity.steam;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AppDetails{

	@JsonProperty("release_date")
	private ReleaseDate releaseDate;

	@JsonProperty("genres")
	private List<GenresItem> genres;

	@JsonProperty("metacritic")
	private Metacritic metacritic;

	@JsonProperty("price_overview")
	private PriceOverview priceOverview;

	@JsonProperty("categories")
	private List<CategoriesItem> categories;

	@JsonProperty("recommendations")
	private int recommendations;

	@JsonProperty("platforms")
	private Platforms platforms;

	public void setReleaseDate(ReleaseDate releaseDate){
		this.releaseDate = releaseDate;
	}

	public ReleaseDate getReleaseDate(){
		return releaseDate;
	}

	public void setGenres(List<GenresItem> genres){
		this.genres = genres;
	}

	public List<GenresItem> getGenres(){
		return genres;
	}

	public void setMetacritic(Metacritic metacritic){
		this.metacritic = metacritic;
	}

	public Metacritic getMetacritic(){
		return metacritic;
	}

	public void setPriceOverview(PriceOverview priceOverview){
		this.priceOverview = priceOverview;
	}

	public PriceOverview getPriceOverview(){
		return priceOverview;
	}

	public void setCategories(List<CategoriesItem> categories){
		this.categories = categories;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	public void setRecommendations(int recommendations){
		this.recommendations = recommendations;
	}

	public int getRecommendations(){
		return recommendations;
	}

	public void setPlatforms(Platforms platforms){
		this.platforms = platforms;
	}

	public Platforms getPlatforms(){
		return platforms;
	}

	@Override
 	public String toString(){
		return 
			"AppDetails{" + 
			"release_date = '" + releaseDate + '\'' + 
			",genres = '" + genres + '\'' + 
			",metacritic = '" + metacritic + '\'' + 
			",price_overview = '" + priceOverview + '\'' + 
			",categories = '" + categories + '\'' + 
			",recommendations = '" + recommendations + '\'' + 
			",platforms = '" + platforms + '\'' + 
			"}";
		}
}