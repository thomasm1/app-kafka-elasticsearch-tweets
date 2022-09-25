package com.revature.services;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import com.revature.beans.User;
import com.revature.services.JSONReaderService;


public interface DistanceService {


	String GOOGLE_APIKEY = System.getenv("googleMapAPIKey");


	public List<User> distanceMatrix (String[] origins, String[] destinations) throws ApiException, InterruptedException, IOException ;
	
	// Place key googleMapAPIKey & value apiKey (to be shared on slack) into Environment Vars.
	public  String getGoogleMAPKey();


	//  AddressController
	public static JSONObject getLocationInfo(String address) {
		StringBuilder stringBuilder = new StringBuilder();
		try {

			address = address.replaceAll(" ", "%20");

			HttpPost httppost = new HttpPost("https://maps.google.com/maps/api/geocode/json?address="
					+ URLEncoder.encode(address) + "&sensor=false&key=" + GOOGLE_APIKEY);
			HttpClient client = new DefaultHttpClient();
			HttpResponse response;
			stringBuilder = new StringBuilder();

			response = client.execute(httppost);
			HttpEntity entity = (HttpEntity) response.getEntity();
			InputStream stream = ((org.apache.http.HttpEntity) entity).getContent();
			int b;
			while ((b = stream.read()) != -1) {
				stringBuilder.append((char) b);
			}
		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject = new JSONObject(stringBuilder.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonObject;
	}

	public static double getLatLong(JSONObject jsonObject) {
		double latitude = 0;
		try {
			latitude = ((JSONArray) jsonObject.get("results"))
					.getJSONObject(0)
					.getJSONObject("geometry")
					.getJSONObject("location")
					.getDouble("lat");
		} catch (JSONException e) {
			System.out.println(e);
			return 0.0;
		}
		return latitude;
	}
}