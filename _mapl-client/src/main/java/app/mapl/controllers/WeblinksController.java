package app.mapl.controllers;

import app.mapl.dto.WeblinkDto;
import app.mapl.service.WeblinksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name = "CRUD REST APIs for Weblink Resource",
        description = "CRUD REST APIs - Create Weblink, Update Weblink, Get Weblink, Get All Weblinks, Delete Weblink"
)
@CrossOrigin(origins = "*")
@RequestMapping(WeblinksController.API_WEBLINKS)
@RestController
public class WeblinksController {
    public static final String API_WEBLINKS = "/api/weblinks";

    @Autowired
    WeblinksService weblinksService;


    @Operation(
            summary = "createWeblinks Weblink By ID REST API ",
            description = "createWeblinks Weblink By ID REST API is used to get a single Weblink from the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED"
    )
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<WeblinkDto> createWeblinks(@RequestBody WeblinkDto c) {

        return new ResponseEntity<>(weblinksService.createWeblinks(c), HttpStatus.CREATED);
    }


    @Operation(
            summary = "GetMapping Weblink By ID REST API ",
            description = "GetMapping Weblink By ID REST API is used to get a single Weblink from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping(value = "/{id}")
    public  ResponseEntity<WeblinkDto>  getWeblinks(@PathVariable("id") long id) {

        return new ResponseEntity<>(weblinksService.getWeblinks(id), HttpStatus.OK);
    }


    @Operation(
            summary = "GetMapping Weblink By ID REST API ",
            description = "GetMapping Weblink By ID REST API is used to get a single Weblink from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping(value = "")
    public ResponseEntity<List<WeblinkDto>> getAllWeblinks() {
        return new ResponseEntity<>(weblinksService.getAllWeblinks(), HttpStatus.OK);
    }


    @Operation(
            summary = "PutMapping Weblink By ID REST API ",
            description = "PutMapping Weblink By ID REST API is used to get a single Weblink from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping(value = "", consumes = "application/json")
    public  ResponseEntity<WeblinkDto>  updateWeblinks(@RequestBody WeblinkDto change) {
        return new ResponseEntity<>(weblinksService.updateWeblinks(change), HttpStatus.OK);
    }


    @Operation(
            summary = "DeleteMapping Weblink By ID REST API ",
            description = "DeleteMapping Weblink By ID REST API is used to get a single Weblink from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping(value = "/{weblinkId}")
    public ResponseEntity<Boolean> deleteWeblinks(@PathVariable("weblinkId") long weblinkId) {
        return new ResponseEntity<>(weblinksService.deleteWeblinks(weblinkId), HttpStatus.OK);
    }
}
