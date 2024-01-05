package run;
import symbols.Symbol;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(calc(text));
    }


    public static String calc(String input) throws Exception {
        Symbol symbol = new Symbol();
        return symbol.terminate(input);
    }
}