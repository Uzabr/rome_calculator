package run;
import symbols.Symbol;

import java.lang.reflect.Array;
        import java.util.ArrayList;
        import java.util.Scanner;

public class Main{
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Symbol symbol = new Symbol();
        symbol.terminate(text);
    }

}