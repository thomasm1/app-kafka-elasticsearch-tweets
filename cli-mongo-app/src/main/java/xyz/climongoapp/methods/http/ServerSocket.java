package xyz.climongoapp.methods.http;

import java.io.IOException;

public class ServerSocket {

    public static void main(String[] args) {
        try(java.net.ServerSocket serverSocket = new java.net.ServerSocket(5000)) {
            while(true) {
                new xyz.climongoapp.methods.http.Echoer(serverSocket.accept()).start();
            }


        } catch(IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
