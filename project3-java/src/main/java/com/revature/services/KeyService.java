package com.revature.services;


public interface KeyService {


	String NASA_APIKEY = System.getenv("nasaAPIKey");

	// Place key nasaAPIKey & value apiKey into Environment Vars.
	public  String getNasaMAPKey();



}