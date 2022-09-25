package com.revature.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

//import com.google.api.client.http.HttpResponse;
import com.google.gson.Gson;
import com.revature.services.DistanceService;
import io.swagger.annotations.Api;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
//import org.json.simple.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * AddressController takes care of handling requests to /address.
 * It provides methods that can perform tasks like returning latitude/longitudes, given an address;
 * Calculations of distances server-side based on different locations is primary objective!
 *
 * @author Thomas Maestas
 *
 */

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*")
@Api(tags= {"Address"})
public class AddressController {

    @Autowired
    Gson gson;

    @Autowired
    private DistanceService ds;

    /**
     * HTTP POST method (/address/lat)
     *
     * @param address represents the new Address being sent.
     *                {
     * "city":"Pittsburgh",
     * "state":"Pennsylvania",
     * "country":"United States",
     * "zipcode":15220
     * }
     * @return A address (currently just latitude.
     */

    @PostMapping(value = "/lat", consumes = "application/json")
    public String getLat(@RequestBody String address) {

        JSONObject jsonObject = DistanceService.getLocationInfo(address);
        String lat = Double.toString(DistanceService.getLatLong(jsonObject));
        return lat;
    }


}
