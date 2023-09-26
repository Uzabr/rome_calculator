package symbols;


import operation.Operations;
import romenumber.RomeNumbers;

import java.util.ArrayList;

public class Symbol {
        public void  terminate(String text) throws Exception {
            int c = 0, d = 0;

            if (checkRome(text)) {
                c =  calculateRomeNumbers(text).get(0);
                d =  calculateRomeNumbers(text).get(1);
                int value = doSomething(text, c, d);
                System.out.println(changeValueToName(value));
            } else  {
                try {
                    int a =  getNumbers(text).get(0);
                    int b =  getNumbers(text).get(1);
                    System.out.println(doSomething(text, a, b));
                }catch (Exception e){
                    System.out.println("You've entered wrong statement");
                }
            }
        }

        public static String changeValueToName(int a){
            RomeNumbers[] romeValues = RomeNumbers.values();
            String name = "";
            for (RomeNumbers rom: romeValues) {
                if (a == rom.getNumbers()){
                    name = rom.name();
                }

            }
            return name;
        }
        public static boolean checkRome(String text) {
            RomeNumbers[] rom = RomeNumbers.values();
            String str = text.replaceAll("[+*-/]", " ");
            String str2 = str.replaceAll("( )+", " ");
            int index = str2.indexOf(" ");
            boolean checkResult = false ;
            String r1 = str2.substring(0, index);
            String r2 = str2.substring(index + 1);
            for (RomeNumbers r : rom) {
                if (r.name().equals(r1)) {
                    checkResult = true;
                }

            }


            return checkResult;

        }

        //проверим если в тексте мат выражения и выполняем соответсвующую операцию
        public  static int doSomething(String text, int a, int b){
            Operations operations = new Operations();
            int result = 0;
            if (text.contains("*")){
                result = operations.multiply(a, b);

            }
            else if (text.contains("/")){
                result = operations.devide(a, b);

            }
            else if (text.contains("-")){
                result = operations.minus(a, b);

            }
            else if (text.contains("+")){
                result = operations.plus(a, b);

            }

            return result;
        }


        // получаем числы из текста
        public static ArrayList<Integer> getNumbers(String text){
            ArrayList<Integer> list = new ArrayList<>();
            String nettext =  text.replaceAll("[*+-/]", "");
            String str = nettext.replaceAll("( )+", " ");
            int index = str.indexOf(" ");
            int a = Integer.parseInt(str.substring(0, index));
            int b = Integer.parseInt(str.substring(index + 1));
            list.add(a);
            list.add(b);
            return list;
        }
        //список, возврашает занвчение enum
        public static ArrayList<Integer> calculateRomeNumbers(String  text){
            RomeNumbers[] romeNumbers = RomeNumbers.values();
            ArrayList<Integer> romeValues = new ArrayList<>();
            //удаляем символы
            String str = text.replaceAll("[+*-/]", " ");
            String str2 = str.replaceAll("( )+", " ");
            int index = str2.indexOf(" ");
            String r1 = str2.substring(0, index);
            String r2 = str2.substring(index +1);
            int firstRomeNumber = 0;
            int secondRomeNumber = 0;
            //проходим по перечислению и сравним имя с текстами r1, r2
            for (RomeNumbers rom : romeNumbers){
                if (rom.name().equals(r1)){
                    firstRomeNumber = rom.getNumbers();
                }
            }
            for (RomeNumbers rom2 : romeNumbers) {
                if (rom2.name().equals(r2)){
                    secondRomeNumber = rom2.getNumbers();
                }

            }

            romeValues.add(firstRomeNumber);
            romeValues.add(secondRomeNumber);
            return romeValues;
        }
}
