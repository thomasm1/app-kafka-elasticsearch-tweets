package app.mapl.controllers;

import app.mapl.models.Weblink;
import app.mapl.service.WeblinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class WeblinksController {
    @Autowired
    WeblinksService weblinksService;

    @RequestMapping(value = "/weblinks", method = RequestMethod.POST, consumes = "application/json")
    public Weblink createWeblinks(@RequestBody Weblink c) {
        return weblinksService.createWeblinks(c);
    }
    @GetMapping(value = "/weblinks/{id}")
    public Weblink getWeblinks(@PathVariable("id") long id) {

        return weblinksService.getWeblinks(id);
    }
    @GetMapping(value = "/weblinks")
    public List<Weblink> getAllWeblinks() {
        return weblinksService.getAllWeblinks();
    }
    @PutMapping(value = "/weblinks", consumes = "application/json")
    public Weblink updateWeblinks(@RequestBody Weblink change) {
        return weblinksService.updateWeblinks(change);
    }
    @DeleteMapping(value = "/weblinks/{weblinkId}")
    public boolean deleteWeblinks(@PathVariable("weblinkId") long weblinkId) {
        return weblinksService.deleteWeblinks(weblinkId);
    }
}
