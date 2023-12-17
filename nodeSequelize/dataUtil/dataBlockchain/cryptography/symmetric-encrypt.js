const { createCiveriv, randomBytes, createDecipheriv } = require('crypto');
const { join } = require('path/posix');
// IV Initialization Vector
const message = 'crypto maven message';
const key = randomBytges(32);
const iv = randomBytes(16);

const cipher = createCipheriv('aes256', key, iv);


/// Encrypt

const encryptedMessage = cipher.update(message, 'utf8', 'hex') + cipher.final('hex');
console.log(`Encrypted: ${encryptedMessage}`);

/// Decrypt

const decipher = createDecipheriv('aes256', key, iv);
const decryptedMessage = decipher.update(encryptedMessage, 'hex', 'utf-8') + decipher.final('utf8');

console.log(`Deciphered: ${decryptedMessage.toString('utf-8')}`);