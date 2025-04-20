package xyz.cryptomaven.rest.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import xyz.cryptomaven.rest.exception.ResourceNotFoundException;
import xyz.cryptomaven.rest.mapper.CoinMapper;
import xyz.cryptomaven.rest.models.dto.CoinDto;
import xyz.cryptomaven.rest.services.CoinService;

import java.util.List;

import static xyz.cryptomaven.rest.util.constants.Constants.API_COINS;


@CrossOrigin(origins = "*")
@RequestMapping(API_COINS)
@RestController
public class CoinController {
  @Autowired
  CoinService coinService;

  @Autowired
  private CoinMapper coinMapper;


  @Operation(summary = "Get all coin")
  @ApiResponse(responseCode = "200", description = "All coin returned")
  @GetMapping(value = {"", "/"}, produces = "application/json")
  public ResponseEntity<List<CoinDto>> getAllCoin() {
    return new ResponseEntity<>(coinService.getAllCoin(), HttpStatus.OK);
  }


  @Operation(summary = "Get a coin by id")
  @ApiResponse(responseCode = "200", description = "Coin returned")
  @GetMapping(value = "/{id}")
  public ResponseEntity<CoinDto> getCoinById(@PathVariable("id") Long id) {
    if (coinService.getCoinById(id).isEmpty()) {
      throw new ResourceNotFoundException("Coin " + id + "not found");
    }
    return coinService.getCoinById(id)
            .map(userDto -> new ResponseEntity<>(userDto, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }


  @Operation(summary = "Create a new coin")
  @ApiResponse(responseCode = "201", description = "Coin created")
  @RequestMapping(value = {"", "/"}, method = RequestMethod.POST, consumes = "application/json")
  @SecurityRequirement(
    name = "Bearer Authentication"
  )
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<CoinDto> createCoin(@RequestBody CoinDto cd) {
    CoinDto response = coinService.createCoin(cd);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }


  @SecurityRequirement(
    name = "Bearer Authentication"
  )
  @PreAuthorize("hasRole('ADMIN')")
  @Operation(summary = "Update a coin")
  @ApiResponse(responseCode = "201", description = "Coin updated")
  @PutMapping(value = {"", "/"}, consumes = "application/json")
  public ResponseEntity<CoinDto> updateCoin(@RequestBody CoinDto change) {
    return new ResponseEntity<>(coinService.updateCoin(change), HttpStatus.OK);
  }

  @SecurityRequirement(
    name = "Bearer Authentication"
  )
  @PreAuthorize("hasRole('ADMIN')")
  @Operation(summary = "Delete a coin")
  @ApiResponse(responseCode = "200", description = "Coin deleted")
  @DeleteMapping(value = "/{id}")
  public boolean deleteCoin(@PathVariable("id") Long id) {

    return coinService.deleteCoin(id);
  }


}
