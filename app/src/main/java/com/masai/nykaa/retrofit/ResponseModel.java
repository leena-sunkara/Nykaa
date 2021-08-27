package com.masai.nykaa.retrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseModel implements Serializable {

	@SerializedName("website_link")
	private String websiteLink;

	@SerializedName("image_link")
	private String imageLink;

	@SerializedName("rating")
	private Object rating;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("api_featured_image")
	private String apiFeaturedImage;

	@SerializedName("product_type")
	private String productType;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("price")
	private String price;

	@SerializedName("tag_list")
	private List<Object> tagList;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("product_colors")
	private List<Object> productColors;

	@SerializedName("brand")
	private String brand;

	@SerializedName("product_api_url")
	private String productApiUrl;

	@SerializedName("product_link")
	private String productLink;

	public String getWebsiteLink(){
		return websiteLink;
	}

	public String getImageLink(){
		return imageLink;
	}

	public Object getRating(){
		return rating;
	}

	public String getDescription(){
		return description;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getApiFeaturedImage(){
		return apiFeaturedImage;
	}

	public String getProductType(){
		return productType;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getPrice(){
		return price;
	}

	public List<Object> getTagList(){
		return tagList;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public List<Object> getProductColors(){
		return productColors;
	}

	public String getBrand(){
		return brand;
	}

	public String getProductApiUrl(){
		return productApiUrl;
	}

	public String getProductLink(){
		return productLink;
	}
}