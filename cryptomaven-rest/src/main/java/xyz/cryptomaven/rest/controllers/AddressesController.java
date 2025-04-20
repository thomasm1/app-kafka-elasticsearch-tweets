package xyz.cryptomaven.rest.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import xyz.cryptomaven.rest.models.dto.AddressDto;

import xyz.cryptomaven.rest.models.dto.ChainDto;
import xyz.cryptomaven.rest.models.dto.CoinDto;
import xyz.cryptomaven.rest.services.AddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static xyz.cryptomaven.rest.util.constants.Constants.API_ADDRESSES;

@CrossOrigin(origins = "*")
@RequestMapping(API_ADDRESSES)
@RestController
public class AddressesController {
  @Autowired
  private AddressesService addressesService;


  @Operation(summary = "Get all addresses")
  @ApiResponse(responseCode = "200", description = "Addresses found")
  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<AddressDto>> getAllAddresses() {

    List<AddressDto> addressDtos = addressesService.getAllAddresses();

    return new ResponseEntity<>(addressDtos, HttpStatus.OK);
  }

  @Operation(summary = "Get an address by id")
  @ApiResponse(responseCode = "200", description = "Address found")
  @GetMapping(value = "/{id}")
  public ResponseEntity<AddressDto> getAddress(@PathVariable("id") Long id) {

    return addressesService.getAddress(id)
            .map(addressDto -> new ResponseEntity<>(addressDto, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @Operation(summary = "Get an address by id")
  @ApiResponse(responseCode = "200", description = "Address found")
  @GetMapping(value = "/{id}/coins")
  public ResponseEntity<Set<CoinDto>> getAddressCoins(@PathVariable("id") Long id) {

    return addressesService.getAddress(id)
            .map(addressDto -> new ResponseEntity<>(addressDto.getCoins() , HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @Operation(summary = "Get an address by id")
  @ApiResponse(responseCode = "200", description = "Address found")
  @GetMapping(value = "/{id}/chains")
  public ResponseEntity<Set<ChainDto>> getAddressCChains(@PathVariable("id") Long id) {

    return addressesService.getAddress(id)
            .map(addressDto -> new ResponseEntity<>(addressDto.getChains() , HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

  }

  @ApiResponse(responseCode = "201", description = "Address created")
  @Operation(summary = "Create a new address")
  @RequestMapping(value = "",  method = RequestMethod.POST, consumes = "application/json")
  public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto c) {

    return new ResponseEntity<>(addressesService.createAddress(c), HttpStatus.CREATED);
  }

  @Operation(summary = "Update an address")
  @ApiResponse(responseCode = "200", description = "Address updated")
  @PutMapping(value= {"", "/"}, consumes = "application/json")
  public ResponseEntity<AddressDto> updateAddress(@RequestBody AddressDto change) {
    return new ResponseEntity<>(addressesService.updateAddress(change), HttpStatus.OK);
  }

  @DeleteMapping(value = "/{addressId}")
  public ResponseEntity<Boolean> deleteAddress(@PathVariable("addressId") Long addressId) {
    return new ResponseEntity<>(addressesService.deleteAddress(addressId), HttpStatus.OK);

  }
}
