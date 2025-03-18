package app.mapl.controller;
 
import app.mapl.dto.APIResponseDto;
import app.mapl.dto.NavigatorDto;
import app.mapl.services.NavigatorService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    ////////////////// REACTIVE //////////////////////////////
    // Build Reactive Save Navigator REST API
//    @PostMapping
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public Mono<NavigatorDto> saveReactiveNavigator(@RequestBody NavigatorDto navigatorDto){
//        return navigatorService.saveReactiveNavigator(navigatorDto);
//    }
//
//    // Build Reactive Get Single Navigator REST API
//    @GetMapping("{id}")
//    public Mono<NavigatorDto> getReactiveNavigator(@PathVariable("id") String navigatorId){
//        return navigatorService.getReactiveNavigator(navigatorId);
//    }

    // Build Reactive Get All Navigators REST API
    @GetMapping
    public Flux<NavigatorDto> getAllReactiveNavigators(){
        return navigatorService.getAllReactiveNavigators();
    }

    // Build Reactive Update Navigator REST API
    @PutMapping("{id}")
    public Mono<NavigatorDto> updateReactiveNavigator(@RequestBody NavigatorDto navigatorDto,
                                                      @PathVariable("id") String navigatorId){
        return navigatorService.updateReactiveNavigator(navigatorDto, navigatorId);
    }

    // Build Reactive Delete Navigator REST API
    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteReactiveNavigator(@PathVariable("id") String navigatorId){
        return navigatorService.deleteReactiveNavigator(navigatorId);
    }

}
