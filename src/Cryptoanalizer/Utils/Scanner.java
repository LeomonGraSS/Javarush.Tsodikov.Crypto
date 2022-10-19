package Cryptoanalizer.Utils;

public class Scanner {
    public static int scanInt() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String scanString() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextLine();
    }
}
