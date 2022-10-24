#!$JAVA_HOME/bin/java --source 11
public class Factorial {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int response = (n==0) ? 0 : 1;
    for (int i = 1; i <= n; i++) {
        response *= i;
      System.out.println("n! " + n +"! = "+ response);

    }
  }
}