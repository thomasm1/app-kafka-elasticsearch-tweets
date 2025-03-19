package xyz.cryptomaven.rest.services;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


@Service
public class Base65EncoderServiceImpl implements Base65EncoderService {
    @Override
    public String encrypt(String freeText) {
        return Base64.getEncoder().encodeToString(freeText.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String decrypt(String encryptedText) {
        return new String(Base64.getDecoder().decode(encryptedText));
    }
}
