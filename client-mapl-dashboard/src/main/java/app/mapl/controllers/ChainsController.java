package app.mapl.controllers;

import app.mapl.models.dto.ChainDto;
import app.mapl.mapper.ChainMapper;
import app.mapl.service.ChainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class ChainsController {
    @Autowired
    ChainsService chainsService;

    @Autowired
    private ChainMapper chainMapper;

    @RequestMapping(value = "/chains", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<ChainDto> createChain(@RequestBody ChainDto cd) {
        ChainDto response = chainsService.createChain(cd);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping(value = "/chains")
    public ResponseEntity<List<ChainDto>> getAllChains() {
        return new ResponseEntity<>(chainsService.getAllChains(), HttpStatus.OK);
    }

    @GetMapping(value = "/chains/{id}")
    public ChainDto getChain(@PathVariable("id") int id) {

        return chainsService.getChain(id);
    }

//    @GetMapping(value = "/chains/{username}")
//    public List<Chain> getAllChainsIOwn(@PathVariable("username") String username) {
//        return null; // chainsService.getAllChainsIOwn(username);
//    }
    @GetMapping(value = "/chains/name/{name}")
    public ResponseEntity<ChainDto> getChainByName(@PathVariable("name") String name) {
        return  new ResponseEntity<>(chainsService.getChainByName(name), HttpStatus.OK);
    }
   @PutMapping(value = "/chains", consumes = "application/json")
    public ResponseEntity<ChainDto> updateChain(@RequestBody ChainDto change) {
        return new ResponseEntity<>(chainsService.updateChain(change), HttpStatus.OK);
    }
    @DeleteMapping(value = "/chains/{id}")
    public boolean deleteChain(@PathVariable("id") int id) {

        return chainsService.deleteChain(id);
    }


}
