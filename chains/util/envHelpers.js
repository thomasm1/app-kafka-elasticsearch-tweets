"use strict";
exports.__esModule = true;
exports.getRequiredEnvVar = exports.setDefaultEnvVar = void 0;
function setDefaultEnvVar(key, defaultValue) {
    var value = process.env[key];
    if (value === undefined) {
        process.env[key] = defaultValue;
    }
}
exports.setDefaultEnvVar = setDefaultEnvVar;
function getRequiredEnvVar(key) {
    var value = process.env[key];
    if (value === undefined) {
        throw Error("".concat(key, " env var does not exist!"));
    }
    return value;
}
exports.getRequiredEnvVar = getRequiredEnvVar;
