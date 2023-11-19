"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (g && (g = 0, op[0] && (_ = 0)), _) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
Object.defineProperty(exports, "__esModule", { value: true });
var moralis_1 = require("moralis");
var express = require("express");
var path = require("path");
var cors = require("cors");
var chains = require("./data/db-constants");
var test = require("./data/db-data");
var app = express();
app.use(function (req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
});
app.use(cors({ origin: true }));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
var EvmChain = require("@moralisweb3/evm-utils").EvmChain;
// const httpsOptions = { 
//   key: fs.readFileSync('/etc/letsencrypt/live/cryptomaven.xyz/privkey.pem'),
//   cert: fs.readFileSync('/etc/letsencrypt/live/cryptomaven.xyz/fullchain.pem')
// };
///////// TEST DATA METHODS
var get_chains_route_1 = require("./routes/get-chains.route");
var search_addresses_route_1 = require("./routes/search-addresses.route");
// searchAddressesByCategory 
var save_chain_route_1 = require("./routes/save-chain.route");
var get_users_route_1 = require("./routes/get-users.route");
// import  {getOpenai} from './routes/openai.route';
var get_nfts_route_1 = require("./routes/get-nfts.route");
/////// LIVE DATA METHODS
var getDataController_1 = require("./controllers/getDataController");
/////////////// CONSTANTS
var PORT = 9000;
var API_KEY = process.env["MORALIS_API_KEY"];
var chain = process.env["DEFAULT_CHAIN"] || 'ETHEREUM';
var addressDEFAULT = process.env["DEFAULT_ADDRESS"];
//// STATIC FILES
app.use(express.static(path.join(__dirname, 'public')));
/// ROUTING
app.route('/api/chains').get(get_chains_route_1.getAllChains);
app.route('/api/chains/:id').get(get_chains_route_1.getChainById);
app.route('/api/nft-refs/:name').get(get_nfts_route_1.getNftRefsByName);
app.route('/api/addresses').get(search_addresses_route_1.searchAddresses);
// app.route('/api/addresses:category').get(searchAddressesByCategory);  
app.route('/api/chains/:id').put(save_chain_route_1.saveChain);
app.route('/api/login').post(get_users_route_1.postLogin);
app.route('/api/users').get(get_users_route_1.getUsers);
app.route('/api/users/email/:email').get(get_users_route_1.getUserById);
app.route('/api/nft-refs').get(get_nfts_route_1.getNftRefs);
app.route('/api/nft-test').get(get_nfts_route_1.getNft);
app.route('/api/nft-test').post(get_nfts_route_1.postNft);
app.route('/api/nfts-test').post(get_nfts_route_1.postNfts);
/// open-ai stuff
app.use('/api/openai', require('./routes/openai.route'));
// app.route('/api/openai').post(getOpenai);
//// LIVE DATA ROUTES
app.get("/api/nft", function (req, res) { return __awaiter(void 0, void 0, void 0, function () {
    var address, data, error_1;
    return __generator(this, function (_a) {
        switch (_a.label) {
            case 0:
                _a.trys.push([0, 2, , 3]);
                address = req.query['address'] || addressDEFAULT;
                chain = req.query['chain'] || chains.chainETH;
                return [4 /*yield*/, (0, getDataController_1.getDataController)(address, chain)];
            case 1:
                data = _a.sent();
                res.status(200);
                res.json(data);
                return [3 /*break*/, 3];
            case 2:
                error_1 = _a.sent();
                console.log(error_1);
                res.status(500);
                res.json({ error: error_1.message });
                return [3 /*break*/, 3];
            case 3: return [2 /*return*/];
        }
    });
}); });
app.post("/api/nft-test", function (req, res) { return __awaiter(void 0, void 0, void 0, function () {
    return __generator(this, function (_a) {
        res.status(200);
        res.json(test.NFTS_ETHEREUM);
        return [2 /*return*/];
    });
}); });
app.post("/api/nft", function (req, res) { return __awaiter(void 0, void 0, void 0, function () {
    var address, data, error_2;
    return __generator(this, function (_a) {
        switch (_a.label) {
            case 0:
                address = req.body.address;
                if (!address || address.length !== 42) {
                    res.status(400);
                    res.json({ error: "Invalid address" });
                }
                ;
                if (!chain || chain.length < 3) {
                    res.status(400);
                    res.json({ error: "Invalid chain" });
                }
                ;
                switch (req.body.chain.toUpperCase()) {
                    case "ETHEREUM":
                        chain = chains.chainETH;
                        break;
                    case "ROPSTEIN":
                        chain = chains.chainROPSTEIN;
                        break;
                    case "RINKEBY":
                        chain = chains.chainRINKEBY;
                        break;
                    case "GOERLI":
                        chain = chains.chainGOERLI;
                        break;
                    case "POLYGON":
                        chain = chains.chainPOLYGON;
                        break;
                    case "MUMBAI":
                        chain = chains.chainMUMBAI;
                        break;
                    case "BNB":
                        chain = chains.chainBSC;
                        break;
                    case "BNB_TEST":
                        chain = chains.chainBSC_TEST;
                        break;
                    case "AVALANCHE":
                        chain = chains.chainAVA;
                        break;
                    case "FUJI":
                        chain = chains.chainFUJI;
                        break;
                    case "FANTOM":
                        chain = chains.chainFANTOM;
                        break;
                    case "ARBITRUM":
                        chain = chains.chainARBITRUM;
                        break;
                    default:
                        res.status(400);
                        res.json({ error: "chain not supported" });
                }
                _a.label = 1;
            case 1:
                _a.trys.push([1, 3, , 4]);
                return [4 /*yield*/, (0, getDataController_1.getDataController)(address, chain)];
            case 2:
                data = _a.sent();
                res.status(200);
                res.json(data);
                return [3 /*break*/, 4];
            case 3:
                error_2 = _a.sent();
                console.log(error_2);
                res.status(500);
                res.json({ error: error_2.message });
                return [3 /*break*/, 4];
            case 4: return [2 /*return*/];
        }
    });
}); });
app.get("api/nft/eth/:address", function (req, res) { return __awaiter(void 0, void 0, void 0, function () {
    var address, chain, data, error_3;
    return __generator(this, function (_a) {
        switch (_a.label) {
            case 0:
                address = req.params.address;
                if (!address || address.length !== 42) {
                    res.status(400);
                    res.json({ error: "Invalid address" });
                }
                ;
                chain = chains.chainETH;
                _a.label = 1;
            case 1:
                _a.trys.push([1, 3, , 4]);
                return [4 /*yield*/, (0, getDataController_1.getDataController)(address, chain)];
            case 2:
                data = _a.sent();
                res.status(200);
                res.json(data);
                return [3 /*break*/, 4];
            case 3:
                error_3 = _a.sent();
                console.log(error_3);
                res.status(500);
                res.json({ error: error_3.message });
                return [3 /*break*/, 4];
            case 4: return [2 /*return*/];
        }
    });
}); });
//// WEBHOOKS
var startServer = function () { return __awaiter(void 0, void 0, void 0, function () {
    return __generator(this, function (_a) {
        switch (_a.label) {
            case 0: return [4 /*yield*/, moralis_1.default.start({
                    apiKey: API_KEY,
                })
                // https.createServer(httpsOptions, app).listen(PORT);
            ];
            case 1:
                _a.sent();
                // https.createServer(httpsOptions, app).listen(PORT);
                app.listen(PORT, function () {
                    console.log("HTTP REST API Server listening at http://localhost:".concat(PORT, "/api/nft"));
                });
                return [2 /*return*/];
        }
    });
}); };
startServer();
