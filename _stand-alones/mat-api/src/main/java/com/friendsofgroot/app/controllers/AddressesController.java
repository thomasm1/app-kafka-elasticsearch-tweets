package com.friendsofgroot.app.controllers;

import com.friendsofgroot.app.exception.ResourceNotFoundException;
import com.friendsofgroot.app.models.dto.AddressDto;
import com.friendsofgroot.app.models.dto.UserDto;
import com.friendsofgroot.app.service.AddressesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.friendsofgroot.app.util.constants.Constants.*;

@CrossOrigin(origins = "*")
@NoArgsConstructor
@AllArgsConstructor
@RestController
public class AddressesController {

    private static final Logger log = LoggerFactory.getLogger(AddressesController.class);

    @Autowired
    AddressesService addressesService;

   private final String ADDRESSES_PATH_ID =  API_ADDRESSES + "/{id}";
    @Operation(
            summary = "Create Address REST API  registerAddress",
            description = "Create Address REST API is used to save addresses in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping(API_ADDRESSES)
    public ResponseEntity<AddressDto> saveAddress(@Validated @RequestBody AddressDto addresses) {
        AddressDto savedAddress = addressesService.createAddress(addresses);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", API_ADDRESSES + "/" + savedAddress.getId());

        return new ResponseEntity<>(savedAddress, headers, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Address By id REST API",
            description = "Get Address By id REST API is used to get a single addresses from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping(value = ADDRESSES_PATH_ID)
    public AddressDto getAddressById(@PathVariable("id") Integer id) {


        log.debug("Get Address by Id - in controller");

        return addressesService.getAddress(id) ;
    }

    @Operation(
            summary = "Get All Addresses REST API",
            description = "Get All Addresses REST API is used to get a all the addressess from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping(value = API_ADDRESSES)
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        return new ResponseEntity<>(addressesService.getAllAddresses(), HttpStatus.OK);
    }



    @Operation(
            summary = "Update Address REST API",
            description = "Update Address REST API is used to update a particular addresses in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping(ADDRESSES_PATH_ID)
    public ResponseEntity<AddressDto> updateAddress(@PathVariable("id") Integer id, @RequestBody AddressDto addressDto) {
        Optional<AddressDto> updated = addressesService.updateAddress(id, addressDto);
        return updated.map(dto -> new ResponseEntity<>(
                dto,
                HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @Operation(
            summary = "Patch Address REST API",
            description = "Patch Address REST API is used to patch - partially update -  a particular addresses from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PatchMapping(ADDRESSES_PATH_ID)
    public ResponseEntity updateAddressPatchById(@PathVariable("id") Integer addressesId, @RequestBody AddressDto addresses) {
        addressesService.patchAddressById(addressesId, addresses);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Delete Address REST API",
            description = "Delete Address REST API is used to delete a particular addresses from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping(value = ADDRESSES_PATH_ID)
    public ResponseEntity<Boolean> deleteAddress(@PathVariable("id") Integer id) {
        Boolean response = false;

        if(! addressesService.deleteAddress(id)){
            throw new ResourceNotFoundException();
        }
        response = true;
        return new ResponseEntity(response, HttpStatus.NO_CONTENT);
    }

}
