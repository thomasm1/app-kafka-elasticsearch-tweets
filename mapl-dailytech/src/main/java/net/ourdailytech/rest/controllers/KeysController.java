package net.ourdailytech.rest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static net.ourdailytech.rest.util.constants.Constant.API_KEYS;


@RestController
@CrossOrigin(origins="*")
@RequestMapping(API_KEYS)
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
		String newkey = System.getenv("MORALIS_API_KEY");
		info.computeIfAbsent("MORALIS_API_KEY", key -> new HashSet<>()).add(newkey);
		return info;
	}
	  @GetMapping("/getNasaApi")
	    public Map<String, Set<String>> getNasaApi() {
	        Map<String, Set<String>> info = new HashMap<>();
	        String newkey = System.getenv("NASA_API_KEY");
	        info.computeIfAbsent("NASA_API_KEY", key -> new HashSet<>()).add(newkey);
	        return info;
	    }
	  @GetMapping("/getGoogleApi")
		public Map<String, Set<String>> getGoogleApi() {
			Map<String, Set<String>> info = new HashMap<>();
			 String newkey =  System.getenv("GOOGLE_API_KEY");
			 info.computeIfAbsent("GOOGLE_API_KEY", key -> new HashSet<>()).add(newkey);
			 return info;
		} 
	  @GetMapping("/getFirebaseApi")
		public Map<String, Set<String>> getFirebaseApi() {
			Map<String, Set<String>> info = new HashMap<>(); 
			 String newkey =  System.getenv("FIREBASE_API_KEY");
			 info.computeIfAbsent("FIREBASE_API_KEY", key -> new HashSet<>()).add(newkey);
			 return info;
		}
	  @GetMapping("/getNytApi")
		public Map<String, Set<String>> getNytApi() {
			Map<String, Set<String>> info = new HashMap<>(); 
			 String newkey =  System.getenv("NYT_API_KEY");
			 info.computeIfAbsent("NYT_API_KEY", key -> new HashSet<>()).add(newkey);
			 return info;
		}
	@GetMapping("/getAnthropicApi")
	public Map<String, Set<String>> getAnthropicApi() {
		Map<String, Set<String>> info = new HashMap<>();
		String newkey =  System.getenv("ANTHRO_API_KEY");
		info.computeIfAbsent("ANTHRO_API_KEY", key -> new HashSet<>()).add(newkey);
		return info;
	}

	@GetMapping("/getGeminiApi")
	public Map<String, Set<String>> getGeminiApi() {
		Map<String, Set<String>> info = new HashMap<>();
		String newkey =  System.getenv("GEMINI_API_KEY");
		info.computeIfAbsent("GEMINI_API_KEY", key -> new HashSet<>()).add(newkey);
		return info;
	}
}
