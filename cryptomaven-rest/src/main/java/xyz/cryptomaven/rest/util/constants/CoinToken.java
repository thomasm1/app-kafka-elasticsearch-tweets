package xyz.cryptomaven.rest.util.constants;

public enum CoinToken {

    ETHEREUM("ETH"),  //0
    MAKERDAO("DAI"),  //1
    HEX("HEX"), //2
  POLYGON("MATIC"),
  BNB("BNB"),
  PULSE_CHAIN("PLS"),
  BITCOIN("BTC"),
  SOL("SOL"),
  AVALANCHE("AVAX"),
  FANTOM("FTM"),
  ONE("ONE"),
  LUNA("LUNA"),
  DOT("DOT"),
  CARDANO("ADA"),
  XRP("XRP"),
  DOGE("DOGE"),
  SHIB("SHIB"),
  UNI("UNI"),
  LINK("LINK"),
  LTC("LTC"),
  BCH("BCH"),
  XLM("XLM"),
  ETC("ETC"),
  VET("VET"),
  TRX("TRX"),
  EOS("EOS"),
  XMR("XMR"),
  DASH("DASH"),
  ZEC("ZEC"),
  XTZ("XTZ"),
  ATOM("ATOM"),
  ALGO("ALGO"),
  FIL("FIL"),

  AAVE("AAVE");  //2

    private CoinToken (String coinToken) {
        this.coinToken = coinToken;
    }
    private String coinToken;
    public String getCoinToken() {
        return coinToken;
    }

}
