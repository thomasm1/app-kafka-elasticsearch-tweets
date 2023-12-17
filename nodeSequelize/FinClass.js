// import "dotenv/config"; // only CRYPTO_API_KEY here

import axios from "axios"; //"../node_modules/axios/src/axios.js";
import { response } from "express";
import SendmailTransport from "nodemailer/lib/sendmail-transport/index.js";
import { ApiWalker } from "./dataUtil/dataServices/dataServices.js";

///////////////// Web Scraping VARS
// GLOBAL VARS     Crypto News

export class FinClass {
  constructor(finObj) {
    // PARAMS
    this.API_KEY = process.env.CRYPTO_API_KEY;
    this.cryptoBaseUrl =
      "https://investing-cryptocurrency-markets.p.rapidapi.com/";
    this.headers = {
      "x-rapidapi-host": "investing-cryptocurrency-markets.p.rapidapi.com",
      "x-rapidapi-key": this.API_KEY,
    };
    // DATA
    this.finObj = finObj || {};

    this.finObj.countriesMarket = [];
    this.finObj.allLangs = [];
    this.finObj.countries = [];
    this.finObj.coins = [];
    this.finObj.cal = [];

    this.apiWalker = new ApiWalker();
  }

  getFinVars(paramOptions) {
    // if coins
    if (paramOptions == "countries")
      return {
        params: {
          locale_info: "en_US",
          lang_ID: "1",
          time_utc_offset: "28800",
        },
        path: "get-meta-data",
      };
    if (paramOptions == "calendar")
      return {
        params: {
          tabname: "ongoing",
          lang_ID: "1",
          time_utc_offset: "28800",
          sort: "related_days",
        },
        path: "get-ico-calendar",
      };
    if (paramOptions == "coinsList")
      return {
        params: {
          edition_currency_id: "12",
          time_utc_offset: "28800",
          lang_ID: "1",
          sort: "PERC1D_DN",
          page: "1",
        },
        path: "coins/list",
      };
    if (paramOptions == "currenciesList")
      return {
        params: {
          lang_ID: "1",
          time_utc_offset: "28800",
        },
      };
  }

  // // Data to return crypto resources   // META DATA

  getMetaData(optString) {
    const localVars = this.getFinVars(optString);

    this.options = {
      headers: this.headers,
      url: `${this.cryptoBaseUrl}${localVars.path}`,
      params: localVars.params,
    };

    const sendCountriesRequest = async () => {
      try {
        const response = await axios.request(this.options);
        this.finObj.countries = response.data;

        for (let i = 0; i < this.finObj.countries.length; i++) {
          apiWalker.newObjMappers.push({
            name: "tempMapper",
            nation: this.finObj.countries.countries[i],
          });
        }
      } catch (err) {
        console.log(response.data);
      }
    };
    sendCountriesRequest();
    return this.finObj.countries;
  }

  // // Data to return crypto resources   // COINS
  getCoinsData() {
    const localVars = this.getFinVars("coinsList");

    this.options = {
      headers: this.headers,
      url: `${this.cryptoBaseUrl}${localVars.path}`,
      params: localVars.params,
    };

    const sendCoinsRequest = async () => {
      try {
        const response = await axios.request(this.options); 
        this.finObj.coins = response.data;
        // console.log(coins[0].screen_data.crypto_data); <=================== USE TEST

        for (let i = 0; i < this.finObj.coins.length; i++) {
          apiWalker.newObjMappers.push({
            name: "tempMapper",
            coin: this.finObj.coins[0].screen_data.crypto_data[i],
          });
        }
        // UNIT TEST // res.json(coins[0].screen_data[2].crypto_data)
        console.log(this.finObj.coins);
      } catch (err) {
        console.log(err);
      }
    };
    sendCoinsRequest();
    return this.finObj.coins;
  }

  // Calendar
  getCalData() {
    // ICO CALENDAR DATA
    const localVars = this.getFinVars("calendar");

    this.options = {
      // method: "GET",  DEFAULT
      headers: this.headers,
      url: `${this.cryptoBaseUrl}${localVars.path}`,
      params: localVars.params,
    };

    const sendCalendarRequest = async () => {
      try {
        const response = await axios.request(this.options);

        // finObj.cal = response.data[0].screen_data.icoData.data
        this.finObj.cal = await response.data;
      } catch (err) {
        console.log(err);
      }
    };
    sendCalendarRequest();
    return this.finObj.cal;
  }
}
