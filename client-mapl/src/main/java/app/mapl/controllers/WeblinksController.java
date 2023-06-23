package app.mapl.controllers;

import app.mapl.dto.WeblinkDto;
import app.mapl.service.WeblinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class WeblinksController {
    @Autowired
    WeblinksService weblinksService;

    @RequestMapping(value = "/weblinks", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<WeblinkDto> createWeblinks(@RequestBody WeblinkDto c) {

        return new ResponseEntity<>(weblinksService.createWeblinks(c), HttpStatus.CREATED);
    }
    @GetMapping(value = "/weblinks/{id}")
    public  ResponseEntity<WeblinkDto>  getWeblinks(@PathVariable("id") long id) {

        return new ResponseEntity<>(weblinksService.getWeblinks(id), HttpStatus.OK);
    }
    @GetMapping(value = "/weblinks")
    public ResponseEntity<List<WeblinkDto>> getAllWeblinks() {
        return new ResponseEntity<>(weblinksService.getAllWeblinks(), HttpStatus.OK);
    }
    @PutMapping(value = "/weblinks", consumes = "application/json")
    public  ResponseEntity<WeblinkDto>  updateWeblinks(@RequestBody WeblinkDto change) {
        return new ResponseEntity<>(weblinksService.updateWeblinks(change), HttpStatus.OK);
    }
    @DeleteMapping(value = "/weblinks/{weblinkId}")
    public ResponseEntity<Boolean> deleteWeblinks(@PathVariable("weblinkId") long weblinkId) {
        return new ResponseEntity<>(weblinksService.deleteWeblinks(weblinkId), HttpStatus.OK);
    }
}
