package com.doggywood.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@CrossOrigin(origins="*")
@RequestMapping("/login")
public class KeysController {
	
	  @GetMapping("/getNasaApi")
	    public Map<String, Set<String>> getNasaApi() {
	        Map<String, Set<String>> info = new HashMap<>();
	        // getting API key
	        String newkey = System.getenv("nasaAPIKey");
	        info.computeIfAbsent("nasaAPIKey", key -> new HashSet<>()).add(newkey);
	        return info;
	    }
	  @GetMapping("/getGoogleApi")
		public Map<String, Set<String>> getGoogleApi() {
			Map<String, Set<String>> info = new HashMap<>();
			 // getting API key
//			 String newkey = ds.getGoogleMAPKey();
			 String newkey =  System.getenv("googleMapAPIKey");
			 info.computeIfAbsent("googleMapAPIKey", key -> new HashSet<>()).add(newkey);
			 return info;
		} 
	  @GetMapping("/getFirebaseApi")
		public Map<String, Set<String>> getFirebaseApi() {
			Map<String, Set<String>> info = new HashMap<>(); 
			 String newkey =  System.getenv("FIREBASE_API");
			 info.computeIfAbsent("FIREBASE_API", key -> new HashSet<>()).add(newkey);
			 return info;
		}
	  @GetMapping("/getNytApi")
		public Map<String, Set<String>> getNytApi() {
			Map<String, Set<String>> info = new HashMap<>(); 
			 String newkey =  System.getenv("NYT_API");
			 info.computeIfAbsent("NYT_API", key -> new HashSet<>()).add(newkey);
			 return info;
		}
}
