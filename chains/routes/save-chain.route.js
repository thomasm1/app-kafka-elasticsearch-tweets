"use strict";
var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.saveChain = void 0;
var db_data_1 = require("../data/db-data");
var timers_1 = require("timers");
function saveChain(req, res) {
    var id = req.params["id"], changes = req.body;
    console.log("Saving new chain", id, JSON.stringify(changes));
    db_data_1.CHAINS[id] = __assign(__assign({}, db_data_1.CHAINS[id]), changes);
    (0, timers_1.setTimeout)(function () {
        res.status(200).json(db_data_1.CHAINS[id]);
    }, 1000); // SPINNER TODO THEN REMOVE
}
exports.saveChain = saveChain;
