package inputCustom;

import java.util.*;
import java.io.*;

public class InputCli {
    public static void main(String []arg) {
        System.out.println("Enter Integers Only: ");
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            getSeries(a, b, n);
        }
        in.close();
    }
    private static void getSeries(int a, int b, int n) {
        int serie = 0;
        String response = "";
        for (int i = 0; i < n; i++) {
            a += ((Math.pow(2,i))*b);
            response += a + "";
        }
//        System.out.println("Input: " +a + "," + b + ", "+n);
        System.out.println("output: " + response);
    }
}


