package net.ourdailytech.rest.service;

public interface Base65EncoderService {

    String encrypt(String freeText);

    String decrypt(String encryptedText);
}
