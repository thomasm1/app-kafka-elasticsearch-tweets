"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.getChainById = exports.getAllChains = void 0;
var db_data_1 = require("../data/db-data");
function getAllChains(req, res) {
    res.status(200).json({ data: Object.values(db_data_1.CHAINS) });
}
exports.getAllChains = getAllChains;
function getChainById(req, res) {
    var chainId = req.params["id"];
    var chains = Object.values(db_data_1.CHAINS);
    var chain = chains.find(function (chain) { return chain.id == +chainId; });
    res.status(200).json(chain);
}
exports.getChainById = getChainById;
