package xyz.climongoapp.methods.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class ClientSocket {

    public static void main(String[] args) throws IOException {
        try ( Socket socket = new Socket("localhost", 5000)) {
            socket.setSoTimeout(5000); // 5 secs
            BufferedReader br  = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do{
                System.out.println("Welcome client: Enter your message: ");
                echoString = scanner.nextLine();

                stringToEcho.println(echoString);
                if(!echoString.equals("exit")) {
                    response = br.readLine();
                    System.out.println(response);
                }
            } while(!echoString.equals("exit"));
        } catch (SocketTimeoutException e) {
            System.out.println("Socket timed out");
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
