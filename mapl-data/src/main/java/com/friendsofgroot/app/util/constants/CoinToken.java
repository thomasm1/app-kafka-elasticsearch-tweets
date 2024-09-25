package com.friendsofgroot.app.util.constants;

public enum CoinToken {

    ETHEREUM("ETH"),  //0
    MAKERDAO("DAI"),  //1
    AAVE("AAVE"),  //2
    HEX("HEX");


    private CoinToken (String coinToken) {
        this.coinToken = coinToken;
    }
    private String coinToken;
    public String getCoinToken() {
        return coinToken;
    }

}
