// Hash-Based Message Authentication Code
// hash that also has a password, like JSON Web Token
const { createHmac } = require('crypto');

const key = 'secret-key';
const message = 'my message';

const hmac = createHmac('sha256', key).update(message).digest('hex');
console.log(hmac);

const key2 = 'other-password';
const hmac2 = createHmac('sha256', key2).update(message).digest('hex');
console.log(hmac);
 