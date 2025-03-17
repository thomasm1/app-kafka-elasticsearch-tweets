package xyz.cryptomaven.rest.services;

public interface Base65EncoderService {

    String encrypt(String freeText);

    String decrypt(String encryptedText);
}
