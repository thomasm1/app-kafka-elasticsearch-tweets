package app.mapl.controllerTests;

import app.mapl.controllers.CoinsController;
import app.mapl.service.CoinsService;
import app.mapl.service.CoinsServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class CoinsControllerTest {
    CoinsController coinsController;
    CoinsService coinsService;

    @BeforeEach
    void setUp() {

        coinsController =  new CoinsController(coinsService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createCoin() {
    }

    @Test
    void getCoin() {
//    coinsController.getCoin(1);
    }

    @Test
    void getAllCoinsIOwn() {
    }

    @Test
    void getAllCoins() {
    }

    @Test
    void getAllCoinsCust() {
    }

    @Test
    void updateCoin() {
    }

    @Test
    void deleteCoin() {
    }

    @Test
    void coinMarketViewAll() {
    }
}