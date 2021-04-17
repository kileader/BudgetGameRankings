package com.kevinleader.bgr.entity.steam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceOverview{

	@JsonProperty("final_formatted")
	private String finalFormatted;

	@JsonProperty("initial")
	private int initial;

	@JsonProperty("final")
	private int jsonMemberFinal;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("initial_formatted")
	private String initialFormatted;

	@JsonProperty("discount_percent")
	private int discountPercent;

	public void setFinalFormatted(String finalFormatted){
		this.finalFormatted = finalFormatted;
	}

	public String getFinalFormatted(){
		return finalFormatted;
	}

	public void setInitial(int initial){
		this.initial = initial;
	}

	public int getInitial(){
		return initial;
	}

	public void setJsonMemberFinal(int jsonMemberFinal){
		this.jsonMemberFinal = jsonMemberFinal;
	}

	public int getJsonMemberFinal(){
		return jsonMemberFinal;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setInitialFormatted(String initialFormatted){
		this.initialFormatted = initialFormatted;
	}

	public String getInitialFormatted(){
		return initialFormatted;
	}

	public void setDiscountPercent(int discountPercent){
		this.discountPercent = discountPercent;
	}

	public int getDiscountPercent(){
		return discountPercent;
	}

	@Override
 	public String toString(){
		return 
			"PriceOverview{" + 
			"final_formatted = '" + finalFormatted + '\'' + 
			",initial = '" + initial + '\'' + 
			",final = '" + jsonMemberFinal + '\'' + 
			",currency = '" + currency + '\'' + 
			",initial_formatted = '" + initialFormatted + '\'' + 
			",discount_percent = '" + discountPercent + '\'' + 
			"}";
		}
}