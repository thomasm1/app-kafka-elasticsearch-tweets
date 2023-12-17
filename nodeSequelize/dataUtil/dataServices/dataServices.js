import { localResponse } from "../../data/js/dataLocalResponse.js";

const nationsShown = {
  "countries": [
    {
      "ci": "104",
      "cc": "AF",
      "cname": "Afghanistan",
      "country_name_translated": "Afghanistan",
      "country_international_phone_code": "+93",
      "flag_image_32x32": "https://i-invdn-com.investing.com/flags_32x32/circle/Afghanistan.png",
      "flag_image_32x32_flat": "https://i-invdn-com.investing.com/flags_32x32_ios/Afghanistan.png"
    }
  ]
}
const coinsShown = {"data": [
  {
    "screen_ID": "83",
    "screen_data": {
      "next_page": 2,
      "crypto_data": [
        {
          "id": "714",
          "name": "Zetacoin",
          "country_id": "767",
          "pair_id": 1071390,
          "currency_symbol": "ZET",
          "inst_price_usd": "0.004087",
          "pair_change_arrow": "up_green",
          "change_percent_1d": "+347.69%",
          "pair_change_percent_numeric": "347.69",
          "change_percent_1d_color": "#3fc932",
          "change_percent_7d": "+0.17%",
          "percent_change_7d_plain": "0.17",
          "change_percent_7d_color": "#3fc932",
          "cross_rates_name": "ZET",
          "inst_price_btc": "0.0000000300043",
          "inst_market_cap": "&#x24;203.80K",
          "inst_market_cap_plain": "203802.75102839136",
          "volume_24h_usd": "&#x24;0",
          "volume_24h_usd_plain": "0",
          "total_volume_plain": "0.00",
          "total_volume": "0.00%",
          "flag_url": "https://i-invdn-com.investing.com/ico_flags/80x80/v32/zetacoin.png",
          "logo_url": "https://i-invdn-com.investing.com/ico_flags/80x80/v32/zetacoin.png"
        } 
          ]
        } 
  }
]
}
  // Financial API
 

export class ApiWalker {
  constructor(newObjMappers, apiArray, apiObj, newsOutlets) {
    // Collect New Fin API session duration vars
    this.newObjMappers = newObjMappers || []

    /// collect local data initially  for testing
    this.apiArray = apiArray || [];
    this.apiObj = apiObj || {};

      /// user's local stored news prefs (for later)
    // this.newsOutlets =  newsOutlets || [];

  }
  // Metadata API
  getLocalAll() {
    for (let i = 0; i < localResponse.countries.length; i++) {
      this.apiObj = localResponse.countries[i];

      this.apiArray.push(this.apiObj);
    }
    return this.apiObj;
  }

  getAll(countriesArrays, strNation) {
    for (let i = 0; i < countriesArrays.length; i++) {
      if (countriesArrays[i].country_name_translated == strNation) {
        this.apiObj = countriesArrays[i];
        this.apiArray.push(this.apiObj);
      } else {
        this.apiArray.push("..mmh, check spelling?");
      }
    }
    return this.apiObj;
  }

  filterUser(array, strNationName) {
    strNationName = strNationName || "Albania";
    array.forEach();
    console.log("articles");

    const alb_name = localResponse.countries[2].country_name_translated;
    console.log("alb_name: " + alb_name);
  }
}

const input = "Algeria";
let a = new ApiWalker();
console.log(a.getAll(input));

console.log(a.getLocalAll());
