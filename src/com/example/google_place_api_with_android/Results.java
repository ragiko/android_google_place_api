package com.example.google_place_api_with_android;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/*
 * @SerializedName　について
 * http://dminor11th.blogspot.jp/2011/08/javajson-gson.html
 */

public class Results {
	public String getFormattedAddress() {
		return formatted_address;
	}

	public String getIcon() {
		return icon;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getRating() {
		return rating;
	}

	public String getReference() {
		return reference;
	}

	public List<String> getTypes() {
		return types;
	}

	@SerializedName("formatted_address") 
	private String formatted_address;

	@SerializedName("icon")
	private String icon;

	@SerializedName("id")
	private String id;

	@SerializedName("name")
	private String name;

	@SerializedName("rating")
	private Double rating;

	@SerializedName("reference")
	private String reference;

	@SerializedName("types")
	private List<String> types;
}