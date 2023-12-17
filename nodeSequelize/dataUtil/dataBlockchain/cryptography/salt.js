// Salt = add random variable(s) to hash
const { scryptSync, randomBytes } = require('crypto');  // synchronous scrypt makes brute force attack unrewarding; proof of work ie bitcoin

function signup(email, pw) {
    const salt = randomBytes(16).toString('hex'); // salt is 16 bytes long 
    const hashedPassword = scryptSync(pw, salt, 64); // key length is 64

    //must store SALT with hash ...
    const user = {email, pw: `${salt}:${hashedPassword}`}
}

function login(email, pw) {
    //grab SALT from database, to decrypt password
    const user = users.find(v => v.email === email);

    const [salt, key] = user.pw.split(':');
    const hashedBuffer = scryptSync(pw, salt, 64);

    const keyBuffer = Buffer.from(key, 'hex');
    
}