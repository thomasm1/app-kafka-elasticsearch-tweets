package xyz.cryptomaven.rest.util;

public interface Base65EncoderService {

    String encrypt(String freeText);

    String decrypt(String encryptedText);
}
