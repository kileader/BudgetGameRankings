package com.kevinleader.bgr.entity.steam;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Price overview.
 */
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

	/**
	 * Instantiates a new Price overview.
	 */
	public PriceOverview() {
	}

	/**
	 * Instantiates a new Price overview.
	 *
	 * @param finalFormatted   the final formatted
	 * @param initial          the initial
	 * @param jsonMemberFinal  the json member final
	 * @param currency         the currency
	 * @param initialFormatted the initial formatted
	 * @param discountPercent  the discount percent
	 */
	public PriceOverview(String finalFormatted, int initial, int jsonMemberFinal, String currency, String initialFormatted, int discountPercent) {
		this.finalFormatted = finalFormatted;
		this.initial = initial;
		this.jsonMemberFinal = jsonMemberFinal;
		this.currency = currency;
		this.initialFormatted = initialFormatted;
		this.discountPercent = discountPercent;
	}

	/**
	 * Set final formatted.
	 *
	 * @param finalFormatted the final formatted
	 */
	public void setFinalFormatted(String finalFormatted){
		this.finalFormatted = finalFormatted;
	}

	/**
	 * Get final formatted string.
	 *
	 * @return the string
	 */
	public String getFinalFormatted(){
		return finalFormatted;
	}

	/**
	 * Set initial.
	 *
	 * @param initial the initial
	 */
	public void setInitial(int initial){
		this.initial = initial;
	}

	/**
	 * Get initial int.
	 *
	 * @return the int
	 */
	public int getInitial(){
		return initial;
	}

	/**
	 * Set json member final.
	 *
	 * @param jsonMemberFinal the json member final
	 */
	public void setJsonMemberFinal(int jsonMemberFinal){
		this.jsonMemberFinal = jsonMemberFinal;
	}

	/**
	 * Get json member final int.
	 *
	 * @return the int
	 */
	public int getJsonMemberFinal(){
		return jsonMemberFinal;
	}

	/**
	 * Set currency.
	 *
	 * @param currency the currency
	 */
	public void setCurrency(String currency){
		this.currency = currency;
	}

	/**
	 * Get currency string.
	 *
	 * @return the string
	 */
	public String getCurrency(){
		return currency;
	}

	/**
	 * Set initial formatted.
	 *
	 * @param initialFormatted the initial formatted
	 */
	public void setInitialFormatted(String initialFormatted){
		this.initialFormatted = initialFormatted;
	}

	/**
	 * Get initial formatted string.
	 *
	 * @return the string
	 */
	public String getInitialFormatted(){
		return initialFormatted;
	}

	/**
	 * Set discount percent.
	 *
	 * @param discountPercent the discount percent
	 */
	public void setDiscountPercent(int discountPercent){
		this.discountPercent = discountPercent;
	}

	/**
	 * Get discount percent int.
	 *
	 * @return the int
	 */
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