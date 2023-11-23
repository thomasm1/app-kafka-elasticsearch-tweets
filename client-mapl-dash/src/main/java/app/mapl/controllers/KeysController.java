package app.mapl.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(KeysController.LOGIN)
public class KeysController {

	public static final String LOGIN = "/login";
	public static final String GET_MORALIS_API = "/getMoralisApi";
	public static final String GET_NASA_API = "/getNasaApi";
	public static final String GET_GOOGLE_API = "/getGoogleApi";
	public static final String GET_FIREBASE_API = "/getFirebaseApi";
	public static final String GET_NYT_API = "/getNytApi";
	private static final String OPENAPI_API = "/getOpenAiAPI"; ;

	@GetMapping(GET_MORALIS_API)
    public Map<String, Set<String>> getMoralisApi() {
        Map<String, Set<String>> info = new HashMap<>();
        // getting API key
        String newkey = System.getenv("MORALIS_API_KEY");
        info.computeIfAbsent("MORALIS_API_KEY", key -> new HashSet<>()).add(newkey);
        return info;
    }

    @GetMapping(GET_NASA_API)
    public Map<String, Set<String>> getNasaApi() {
        Map<String, Set<String>> info = new HashMap<>();
        // getting API key
        String newkey = System.getenv("nasaAPIKey");
        info.computeIfAbsent("nasaAPIKey", key -> new HashSet<>()).add(newkey);
        return info;
    }

    @GetMapping(GET_GOOGLE_API)
    public Map<String, Set<String>> getGoogleApi() {
        Map<String, Set<String>> info = new HashMap<>();
        // getting API key
//			 String newkey = ds.getGoogleMAPKey();
        String newkey = System.getenv("googleMapAPIKey");
        info.computeIfAbsent("googleMapAPIKey", key -> new HashSet<>()).add(newkey);
        return info;
    }

    @GetMapping(GET_FIREBASE_API)
    public Map<String, Set<String>> getFirebaseApi() {
        Map<String, Set<String>> info = new HashMap<>();
        String newkey = System.getenv("FIREBASE_API");
        info.computeIfAbsent("FIREBASE_API", key -> new HashSet<>()).add(newkey);
        return info;
    }

    @GetMapping(GET_NYT_API)
    public Map<String, Set<String>> getNytApi() {
        Map<String, Set<String>> info = new HashMap<>();
        String newkey = System.getenv("NYT_API");
        info.computeIfAbsent("NYT_API", key -> new HashSet<>()).add(newkey);
        return info;
    }
   @GetMapping(OPENAPI_API)
	public Map<String, Set<String>> getOpenAiApi() {
	   Map<String, Set<String>> info = new HashMap<>();
	   String newkey = System.getenv("OPENAI_API_KEY");
	   info.computeIfAbsent("OPENAPI_API_KEY", key -> new HashSet<>()).add(newkey);
   	return info;
	}
}
