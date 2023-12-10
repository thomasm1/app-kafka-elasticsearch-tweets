package app.mapl.controllers;

import app.mapl.dto.CoinDto;
import app.mapl.service.CoinsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/coins")
@RestController
public class CoinsController {

    public CoinsService coinsService;

    public CoinsController(CoinsService coinsService) {
        this.coinsService = coinsService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<CoinDto> createCoin(@RequestBody CoinDto c) {

        return new ResponseEntity<>(coinsService.createCoin(c), HttpStatus.CREATED);
    }
    @GetMapping(value = "{coinId}")
    public ResponseEntity<CoinDto> getCoin(@PathVariable("coinId") int coinId) {

        return new ResponseEntity<>(coinsService.getCoin(coinId), HttpStatus.OK);
    }

    @GetMapping(value = "{username}")
    public ResponseEntity<List<CoinDto>> getAllCoinsCust(@PathVariable("username") String username) {
        return   new ResponseEntity<>(coinsService.getAllCoinsIOwn(username), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<CoinDto>> getAllCoins() {

        return new ResponseEntity<>(coinsService.getAllCoins(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<List<CoinDto>> getAllCoinsCust(@PathVariable("id") int id) {
        return new ResponseEntity<>(coinsService.getAllCoinsCust(), HttpStatus.OK);
    }
   @PutMapping(value = "", consumes = "application/json")
    public ResponseEntity<CoinDto> updateCoin(@RequestBody CoinDto change) {
        return new ResponseEntity<>( coinsService.updateCoin(change), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "{coinId}")
    public ResponseEntity<Boolean> deleteCoin(@PathVariable("coinId") int coinId) {
        return new ResponseEntity<>(coinsService.deleteCoin(coinId), HttpStatus.OK);
    }
    @GetMapping(value = "/market")
    public void coinMarketViewAll() {
        coinsService.coinMarketViewAll();
    }

}
