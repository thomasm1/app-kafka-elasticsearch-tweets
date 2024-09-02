package app.mapl.util.methods.cryptography;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hashing {

    private void hash(String s) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] input = s.getBytes();
        byte[] digest = messageDigest.digest(input);
//        Utils.printByteArray("Digest ", digest);
        String str = Base64.getEncoder().encodeToString(digest);
        System.out.println("Input: " + str);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Hashing h = new Hashing();
        System.out.println("one way only".toUpperCase());
        h.hash("this is a smaller text");

        System.out.println("deterministic".toUpperCase());
        h.hash("this is a smaller textthis is a smaller text");

        System.out.println("pseudorandom".toUpperCase());
        h.hash("this is a smaller textthis is a smaller textthis is a smaller text");
    }
}
