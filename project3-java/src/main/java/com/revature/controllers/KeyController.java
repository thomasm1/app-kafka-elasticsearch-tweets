package com.revature.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.KeyService;
import com.revature.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * KeyController returns api keys from environment
 *
 * @author Thomas Maestas
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class KeyController {

//    @Autowired
//    private KeyService ks;

    @GetMapping("/getNasaApi")
    public Map<String, Set<String>> getNasaApi() {
        Map<String, Set<String>> info = new HashMap<>();
        // getting API key
        String newkey = System.getenv("nasaAPIKey");
//        String newkey = ks.getNasaMAPKey();
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
