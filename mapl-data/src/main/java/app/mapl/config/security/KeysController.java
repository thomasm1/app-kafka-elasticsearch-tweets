package app.mapl.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//import static app.mapl.security.SpringSecurityConfiguration.getAuthenticatedUsername;


@RestController 
@CrossOrigin(origins="*")
@RequestMapping("/login")
@SessionAttributes("name")
public class KeysController {

	private static final Logger log = LoggerFactory.getLogger(KeysController.class);
	HashMap<String, String> map = new HashMap<>();
//
//	@GetMapping(value="/")
//	public ResponseEntity<String> userHome() {
//		String name = getAuthenticatedUsername();
//		map.put("name", name);
//		return new ResponseEntity<>("Auth Controller Complete: "+name, HttpStatus.OK);
//	}

	@GetMapping("/getMoralisApi")
	public Map<String, Set<String>> getMoralisApi() {
		Map<String, Set<String>> info = new HashMap<>();
		// getting API key
		String newkey = System.getenv("MORALIS_API_KEY");
		info.computeIfAbsent("MORALIS_API_KEY", key -> new HashSet<>()).add(newkey);
		return info;
	}
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
