package xyz.cryptomaven.rest.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.cryptomaven.rest.models.dto.NftCoinDto;
import xyz.cryptomaven.rest.models.dto.MetadataDto;
import xyz.cryptomaven.rest.services.NftService;
import xyz.cryptomaven.rest.util.constants.Constants;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(Constants.API_NFT_COINS)
@RestController
public class NftCoinController {

  private static final Logger log = LoggerFactory.getLogger(NftCoinController.class);
  @Autowired
  private NftService nftService; // Use the interface here
  @Operation(summary = "Get NFT by ID")
  @ApiResponse(responseCode = "200", description = "NFT found")
  @GetMapping(value = "/{id}")
  public ResponseEntity<NftCoinDto> getNft(@PathVariable("id") Long id) {
    return nftService.getNft(id)
            .map(nftDto -> new ResponseEntity<>(nftDto, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @Operation(summary = "Get NFT Metadata by ID")
  @ApiResponse(responseCode = "200", description = "NFT found")
  @GetMapping(value = "/{id}/metadata")
  public ResponseEntity<MetadataDto> getMetadata(@PathVariable("id") Long id) {
    return nftService.getNft(id)
            .map(nftDto  -> new ResponseEntity<>(nftDto.getMetadata(), HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  @Operation(summary = "Get all NFTs")
  @ApiResponse(responseCode = "200", description = "NFTs found")
  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<NftCoinDto>> getAllNfts() {
    return new ResponseEntity<>(nftService.getAllNFTs(), HttpStatus.OK);
  }

  @Operation(summary = "Create a new NFT")
  @ApiResponse(responseCode = "201", description = "NFT created")
  @RequestMapping(value = {"", "/"}, method = RequestMethod.POST, consumes = "application/json")
  public ResponseEntity<NftCoinDto> createNft(@RequestBody NftCoinDto n) {
    return new ResponseEntity<>(nftService.createNft(n), HttpStatus.CREATED);
  }

  @Operation(summary = "Update NFT")
  @ApiResponse(responseCode = "201", description = "NFT updated")
  @PutMapping(value = {"", "/", "/{id}"}, consumes = "application/json")
  public ResponseEntity<Boolean> updateNft(@RequestBody NftCoinDto change,  @PathVariable("id") Long id) {
        log.info(change.toString() + id);
    return new ResponseEntity<>(nftService.updateNft(change), HttpStatus.CREATED);
  }

  @Operation(summary = "Delete NFT")
  @ApiResponse(responseCode = "200", description = "NFT deleted  ResponseEntity<Boolean> ")
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Boolean> deleteNft(@PathVariable("id") Long addressId) {
    return new ResponseEntity<>(nftService.deleteNft(addressId), HttpStatus.OK);
  }
}