package app.mapl.controllers;

import app.mapl.models.dto.NftDto;
import app.mapl.service.NftService;
import app.mapl.util.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(Constants.API_NFTS)
@RestController
public class NftController {

    private static final Logger log = LoggerFactory.getLogger(NftController.class);
    @Autowired
    private NftService nftService;


    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Boolean> createNft(@RequestBody NftDto n) {

        return new ResponseEntity<>(nftService.createNft(n), HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<NftDto>  getNft(@PathVariable("id") int id) {

        return new ResponseEntity<>(nftService.getNft(id), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<NftDto>> getAllNfts() {
        return  new ResponseEntity<>(nftService.getAllNfts(), HttpStatus.OK);
    }

    @PutMapping(value = "", consumes = "application/json")
    public ResponseEntity<Boolean> updateNft(@RequestBody NftDto change) {
        return new ResponseEntity<>(nftService.updateNft(change), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteNft(@PathVariable("id") int addressId) {
        return new ResponseEntity<>(nftService.deleteNft(addressId), HttpStatus.OK);
    }


}
