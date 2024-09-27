
Java Application using cryptographic functions [App layer]
____________________________
Java Cryptography Architecture [abstract layer]
Java Cryptography Extension
____________________________
Cryptographic Service Providers
---SunJCE ------------- BouncyCastle --------- Other CSP [provider layer]

#####################################
```sh
 Security.addProvider (new SpecificProvider()); // extends java.security.Provider
 ## OR
 # JDK 8 jre/lib/security.provider.Sun 
 # JDK 9+ conf/security/java.security
 security.provider.1=sun.security.provider.Sun
 security.provider.2=sun.security.rsa.SunRsaSign
 security.provider.3=com.specificproivder.SpecificProvider
 
```
Interface/class 

### Technologies
| Interface/class  |                          Function                           |   URLS |
|------------------|:-----------------------------------------------------------:|-------:|
| Security         |                       Provider config                       |    [ ] | 
| KeyGenerator     |                   Generates symmetric key                   |  [ - ] | 
| Key              |                   Represents key material                   |   [ -] |
| Cipher           |                    Encryption algorithm                     |    [ ] |
| SecretKeyFactory | Converts symmetric key material to secretKey abstraction    |    [ ] |
| KeyStore         |         Storing mechanism for keys and certificates         |    [ ] |
| MessageDigest    |                           Hashing                           |    [ ] |
| HMAC             |               Combines hashing and encryption               |    [ ] |

* MD-5 (hash size 128 bits) HACKED
* SHA-1 (hash size 160 bits)
* SHA-256 (hash size 256 bits)

SYMMETRIC ENCRYPTION
* DES (Data Encryption Standard) HACKED
    * Block size 64 bits, keysize 56 bits 
* AES (Advanced Encryption Standard)
    * Block size 128 bits, keysize 128/192/256 bits 
    * // KeyGenerator => Key init(key) => Cipher


