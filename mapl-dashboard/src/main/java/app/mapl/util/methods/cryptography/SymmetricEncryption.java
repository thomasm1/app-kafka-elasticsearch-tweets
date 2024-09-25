package app.mapl.util.methods.cryptography;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SymmetricEncryption {

    public void symEncryption() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator generator;
        try {
            generator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //specifiy want a key length of 192 bits, for AES
        generator.init(192);
        Key key = generator.generateKey();
        String str = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println("Input: " + str);

        byte[] input = "devox".repeat(16).getBytes();
        String str2 = Base64.getEncoder().encodeToString(input);
        System.out.println("Input: " + str2);

        Cipher cipher;
        byte[] encryptedOutput;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encryptedOutput = cipher.doFinal(input);
            String str3 = Base64.getEncoder().encodeToString(encryptedOutput);
            System.out.println("encryptedOutput: " + str3);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }

        //decryption
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedOutput = cipher.doFinal(encryptedOutput);
        String str4 = Base64.getEncoder().encodeToString(decryptedOutput);
        System.out.println("Decoded Input: "+ str4);

    }

    public static void main(String[] args) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SymmetricEncryption sym = new SymmetricEncryption();
        sym.symEncryption();
    }
}
