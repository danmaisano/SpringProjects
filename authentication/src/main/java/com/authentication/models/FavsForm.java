package com.authentication.models;

import java.util.ArrayList;

public class FavsForm {
    private String favBook;
    private String favFood;
    private String favPet;
    private ArrayList<String> favCodingLanguage = new ArrayList<>();
	public String getFavBook() {
		return favBook;
	}
	public void setFavBook(String favBook) {
		this.favBook = favBook;
	}
	public String getFavFood() {
		return favFood;
	}
	public void setFavFood(String favFood) {
		this.favFood = favFood;
	}
	public String getFavPet() {
		return favPet;
	}
	public void setFavPet(String favPet) {
		this.favPet = favPet;
	}
	public ArrayList<String> getFavCodingLanguage() {
		return favCodingLanguage;
	}
	public void setFavCodingLanguage(ArrayList<String> favCodingLanguage) {
		this.favCodingLanguage = favCodingLanguage;
	}
    
    
}
