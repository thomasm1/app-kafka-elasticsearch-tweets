package app.mapl.controllers;

import app.mapl.models.Coin;
import app.mapl.service.CoinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class CoinsController {
    @Autowired
    CoinsService coinsService;

    @RequestMapping(value = "/coins", method = RequestMethod.POST, consumes = "application/json")
    public Coin createCoin(@RequestBody Coin c) {
        return coinsService.createCoin(c);
    }
    @GetMapping(value = "/coins/{coinId}")
    public Coin getCoin(@PathVariable("coinId") int coinId) {

        return coinsService.getCoin(coinId);
    }

    @GetMapping(value = "/coins/{username}")
    public List<Coin> getAllCoinsIOwn(@PathVariable("username") String username) {
        return null; // coinsService.getAllCoinsIOwn(username);
    }

    @GetMapping(value = "/coins")
    public List<Coin> getAllCoins() {
        return coinsService.getAllCoins();
    }

    @GetMapping(value = "/coins/{id}")
    public List<Coin> getAllCoinsCust(@PathVariable("id") int id) {
        return coinsService.getAllCoinsCust();
    }
   @PutMapping(value = "/coins", consumes = "application/json")
    public Coin updateCoin(@RequestBody Coin change) {
        return coinsService.updateCoin(change);
    }
    @DeleteMapping(value = "/coins/{coinId}")
    public boolean deleteCoin(@PathVariable("coinId") int coinId) {
        return coinsService.deleteCoin(coinId);
    }
    @GetMapping(value = "/coins/market")
    public void coinMarketViewAll() {
        coinsService.coinMarketViewAll();
    }

}
