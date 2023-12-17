const { createHash } = require('crypto');

function hash(input) {
    return createHash('sha256') // 'md5' algorithm no good for api Key, too weak. Deprecated by NIST}
        .update(input)
        .digest('hex'); // DIGEST == OUTPUT  
                        // hexadecimal 'hex' format or can use 'base64' format
}
let password = 'password123';
const hash1 = hash(password);
console.log(hash1)

/// compare: 
password = 'New-Password';
const hash2 = hash(password);
const match = hash1 === hash2;

console.log(match ? 'Good password': 'Bad password')


