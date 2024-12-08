package app.mapl.controllers;

import app.mapl.exception.ResourceNotFoundException;
import app.mapl.models.dto.ChainDto;
import app.mapl.service.ChainsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.util.List;

import static app.mapl.util.constants.Constants.API_CHAINS;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RestController
public class ChainsController {

    private static final Logger log = LoggerFactory.getLogger(ChainsController.class);

    public static final String CHAIN_PATH = API_CHAINS;
    public static final String CHAIN_PATH_ID = CHAIN_PATH + "/{chainId}";

    private final ChainsService chainService;

    @Operation(
            summary = "Create Chain REST API  registerChain",
            description = "Create Chain REST API is used to save chain in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping(CHAIN_PATH)
    public ResponseEntity<ChainDto> saveChain(@Validated @RequestBody ChainDto chain) {
        ChainDto savedChain = chainService.saveNewChain(chain);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", CHAIN_PATH + "/" + savedChain.getId());

        return new ResponseEntity<>(savedChain, headers, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get All Chains REST API",
            description = "Get All Chains REST API is used to get a all the chains from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping(value = CHAIN_PATH)
    public ResponseEntity<List<ChainDto>> getAllChains() {
        return new ResponseEntity<>(chainService.getAllChains(), HttpStatus.OK);
    }
    @Operation(
            summary = "Get All Chains REST API Pageable",
            description = "Get All Chains REST API is used to get a all the chains from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping(value = CHAIN_PATH + "/page")
    public ResponseEntity<Page<ChainDto>> getAllChainsPageable(@RequestBody  Pageable page) {

        return new ResponseEntity<>(chainService.getAllChainsPageable(page), HttpStatus.OK);
    }
    @Operation(
            summary = "Get Chain By id REST API",
            description = "Get Chain By id REST API is used to get a single chain from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping(value = CHAIN_PATH_ID)
    public ChainDto getChainByChainId(@PathVariable("chainId") Integer chainId) {


        log.debug("Get Chain by Id - in controller");

        return chainService.getChainByChainId(chainId).orElseThrow(ResourceNotFoundException::new);
    }

    @Operation(
            summary = "Get Chain By name-of-chain REST API",
            description = "Get Chain By name REST API is used to get a single chain from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping(value = CHAIN_PATH + "/name/{name}")
    public ResponseEntity<ChainDto> getChainByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(chainService.getChainByName(name), HttpStatus.OK);
    }


    @Operation(
            summary = "Update Chain REST API",
            description = "Update Chain REST API is used to update a particular chain in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping(CHAIN_PATH_ID)
    public ResponseEntity updateById(@PathVariable("chainId") Integer chainId, @Validated @RequestBody ChainDto chain) {
        if (chainService.updateChainByChainId(chainId, chain).isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Patch Chain REST API",
            description = "Patch Chain REST API is used to patch - partially update -  a particular chain from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PatchMapping(CHAIN_PATH_ID)
    public ResponseEntity updateChainPatchById(@PathVariable("chainId") Integer chainId, @RequestBody ChainDto chain) {
        chainService.patchChainById(chainId, chain);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @Operation(
            summary = "Delete Chain REST API",
            description = "Delete Chain REST API is used to delete a particular chain from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping(value = CHAIN_PATH_ID)
    public ResponseEntity<Boolean> deleteChain(@PathVariable("chainId") Integer chainId) {
        Boolean response = false;

        if(! chainService.deleteById(chainId)){
            throw new ResourceNotFoundException();
        }
        response = true;
        return new ResponseEntity(response, HttpStatus.NO_CONTENT);
    }


}
