package xyz.cryptomaven.rest.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static xyz.cryptomaven.rest.util.constants.Constants.API_KEYS;


@RestController
@CrossOrigin(origins="*")
@RequestMapping(API_KEYS)
@SessionAttributes("name")
public class KeysController {

	private static final Logger log = LoggerFactory.getLogger(KeysController.class);
	HashMap<String, String> map = new HashMap<>();
@ApiResponse(responseCode = "200", description = "API keys found")
@Operation(summary = "Get MORALIS_API_KEY API keys")
	@GetMapping("/getMoralisApi")
	public Map<String, Set<String>> getMoralisApi() {
		Map<String, Set<String>> info = new HashMap<>();
		String newkey = System.getenv("MORALIS_API_KEY");
		info.computeIfAbsent("MORALIS_API_KEY", key -> new HashSet<>()).add(newkey);
		return info;
	}

  @ApiResponse(responseCode = "200", description = "get NASA_API_KEY keys found")
  @Operation(summary = "Get NASA_API_KEY API keys")
	  @GetMapping("/getNasaApi")
	    public Map<String, Set<String>> getNasaApi() {
	        Map<String, Set<String>> info = new HashMap<>();
	        String newkey = System.getenv("NASA_API_KEY");
	        info.computeIfAbsent("NASA_API_KEY", key -> new HashSet<>()).add(newkey);
	        return info;
	    }
      @ApiResponse(responseCode = "200", description = "get  GOOGLE_API_KEY found")
      @Operation(summary = "Get GOOGLE_API_KEY keys")
	  @GetMapping("/getGoogleApi")
		public Map<String, Set<String>> getGoogleApi() {
			Map<String, Set<String>> info = new HashMap<>();
			 String newkey =  System.getenv("GOOGLE_API_KEY");
			 info.computeIfAbsent("GOOGLE_API_KEY", key -> new HashSet<>()).add(newkey);
			 return info;
		}
    @ApiResponse(responseCode = "200", description = "get FIREBASE_API_KEY found")
      @Operation(summary = "Get FIREBASE_API_KEY API keys")
	  @GetMapping("/getFirebaseApi")
		public Map<String, Set<String>> getFirebaseApi() {
			Map<String, Set<String>> info = new HashMap<>();
			 String newkey =  System.getenv("FIREBASE_API_KEY");
			 info.computeIfAbsent("FIREBASE_API_KEY", key -> new HashSet<>()).add(newkey);
			 return info;
		}
    @ApiResponse(responseCode = "200", description = "API NYT_API_KEY found")
      @Operation(summary = "Get NYT_API_KEY   keys")
	  @GetMapping("/getNytApi")
		public Map<String, Set<String>> getNytApi() {
			Map<String, Set<String>> info = new HashMap<>();
			 String newkey =  System.getenv("NYT_API_KEY");
			 info.computeIfAbsent("NYT_API_KEY", key -> new HashSet<>()).add(newkey);
			 return info;
		}
    @ApiResponse(responseCode = "200", description = "ANTHRO_API_KEY API keys found")
      @Operation(summary = "Get ANTHRO_API_KEY getAnthropicApi API keys")
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
