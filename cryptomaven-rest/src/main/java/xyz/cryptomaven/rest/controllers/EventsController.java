package xyz.cryptomaven.rest.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import xyz.cryptomaven.rest.models.dto.PagedResponse;

import static xyz.cryptomaven.rest.util.constants.Constants.API_EVENT;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(API_EVENT)
@SessionAttributes("name")
public class EventsController {

	private static final Logger log = LoggerFactory.getLogger(EventsController.class);

@ApiResponse(responseCode = "200", description = "EVENTS_BUS keys found")
@Operation(summary = "API_EVENTS_BUS")
	@GetMapping("/events")
	public String getEvent() {
	return "EVENTS_BUS keys found";
	}

}