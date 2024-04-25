package app.mapl.controllers;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//@RefreshScope(ConditionalOnProperty="app.mapl.keys")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(KeysController.KEYS)
@ConfigurationProperties(prefix = "app.mapl.keys")
public class KeysController<Mapl> {

    Logger log = LoggerFactory.getLogger(KeysController.class);

    public static final String KEYS = "/keys/";
	public static final String GET_MORALIS_API = "/getMoralisApi";
	public static final String GET_NASA_API = "/getNasaApi";
	public static final String GET_GOOGLE_API = "/getGoogleApi";
	public static final String GET_FIREBASE_API = "/getFirebaseApi";
	public static final String GET_NYT_API = "/getNytApi";
	private static final String OPENAPI_API = "/getOpenAiAPI"; ;

    @Value("${spring.boot.message}")
    private String message;
    @Value("${spring.boot.newprofile}")
    private String newprofile;
//    @Value("${spring.boot.mapl}")
    private class Mapl {
        private String name;
        private String description;
        private String version;
        private String author;
        private String email;
        private String github;
}

     @GetMapping("newprofile")
     public String newprofile(){
         return newprofile;
     }
     @GetMapping("message")
     public String message(){
         return message;
     }

    @GetMapping("/app-info")
    public Map<String, String> getAppInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("name", "Mapl");
        info.put("description", "Mapl is a web application that allows users to view and share information about the world around them.");
        info.put("version", "1.0.0");
        info.put("author", "Thomas Maestas");
        info.put("email", "thomas76milton@gmail.com");
        return info;
    }

    @GetMapping("/mapl")
    public ResponseEntity<Map<String, Mapl>> getMapl() {

        Map maplHash = new HashMap<String, Mapl>();
        maplHash.put("name", "Mapl");
        maplHash.put("description", "Mapl is a web application that allows users to view and share information about the world around them.");
        maplHash.put("version", "1.0.0");
        maplHash.put("author", "Thomas Maestas");
        maplHash.put("email", "info@armchairbitcoinist.com");
        maplHash.put("github", "https://github.com/Thomasm1/Mapl");

        return ResponseEntity.status(HttpStatus.OK).body(maplHash);
    }
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
