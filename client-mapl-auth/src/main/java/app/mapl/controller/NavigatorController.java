package app.mapl.controller;
 
import app.mapl.dto.APIResponseDto;
import app.mapl.dto.NavigatorDto;
import app.mapl.service.NavigatorService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/navigators")
@AllArgsConstructor
public class NavigatorController {

    private NavigatorService navigatorService;

    // Build Save Navigator REST API
    @PostMapping
    public ResponseEntity<NavigatorDto> saveNavigator(@RequestBody NavigatorDto navigatorDto){
        NavigatorDto savedNavigator = navigatorService.saveNavigator(navigatorDto);
        return new ResponseEntity<>(savedNavigator, HttpStatus.CREATED);
    }

    // Build Get Navigator REST API
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getNavigator(@PathVariable("id") Long navigatorId){
        APIResponseDto apiResponseDto = navigatorService.getNavigatorById(navigatorId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
