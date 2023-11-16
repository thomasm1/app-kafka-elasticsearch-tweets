"use strict";
exports.__esModule = true;
exports.validateAlchemySignature = exports.addAlchemyContextToRequest = exports.isValidSignatureForStringBody = exports.isValidSignatureForAlchemyRequest = void 0;
var crypto = require("crypto");
function isValidSignatureForAlchemyRequest(request, signingKey) {
    return isValidSignatureForStringBody(request.alchemy.rawBody, request.alchemy.signature, signingKey);
}
exports.isValidSignatureForAlchemyRequest = isValidSignatureForAlchemyRequest;
function isValidSignatureForStringBody(body, signature, signingKey) {
    var hmac = crypto.createHmac("sha256", signingKey); // Create a HMAC SHA256 hash using the signing key
    hmac.update(body, "utf8"); // Update the token hash with the request body using utf8
    var digest = hmac.digest("hex");
    return signature === digest;
}
exports.isValidSignatureForStringBody = isValidSignatureForStringBody;
function addAlchemyContextToRequest(req, _res, buf, encoding) {
    var signature = req.headers["x-alchemy-signature"];
    // Signature must be validated against the raw string
    var body = buf.toString(encoding || "utf8");
    req.alchemy = {
        rawBody: body,
        signature: signature
    };
}
exports.addAlchemyContextToRequest = addAlchemyContextToRequest;
function validateAlchemySignature(signingKey) {
    return function (req, res, next) {
        if (!isValidSignatureForAlchemyRequest(req, signingKey)) {
            var errMessage = "Signature validation failed, unauthorized!";
            res.status(403).send(errMessage);
            throw new Error(errMessage);
        }
        else {
            next();
        }
    };
}
exports.validateAlchemySignature = validateAlchemySignature;
