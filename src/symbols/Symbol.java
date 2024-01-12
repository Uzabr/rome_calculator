package symbols;


import operation.Operations;
import romenumber.RomeNumbers;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Symbol {
        public String  terminate(String text) throws Exception {
            int c = 0, d = 0;

            if (checkRome(text)) {

                c =  calculateRomeNumbers(text).get(0);
                d =  calculateRomeNumbers(text).get(1);
                if (d < c) {
                    throw new ArithmeticException("Result cannot be less than 1 for Roman numerals");
                }
                int value = doSomething(text, c, d);
                    return changeValueToName(value);
            } else  {
                    int a =  getNumbers(text).get(0);
                    int b =  getNumbers(text).get(1);
                    return Integer.toString(doSomething(text, a, b));
            }
        }

        public static String changeValueToName(int a){
//            RomeNumbers[] romeValues = RomeNumbers.values();
            int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] romeValues = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            StringBuilder builder = new StringBuilder();

            String name = "";

            for (int i =0; i < values.length; i++ ) {
                while (a >= values[i]) {
                    a = a - values[i];
                    builder.append(romeValues[i]);
                }
            }
            return builder.toString();
        }
        public static boolean checkRome(String text) {
            RomeNumbers[] rom = RomeNumbers.values();
            if(isNumber(text)) {
                throw new ArithmeticException("Invalid input");
            }
            String str = text.replaceAll("[+*-/]", " ");
            String str2 = str.replaceAll("( )+", " ");
            int index = str2.indexOf(" ");
            boolean checkResult = false ;
            String r1 = str2.substring(0, index);
            String r2 = str2.substring(index + 1);

//            if (Character.isDigit(Integer.parseInt(r2)) && Character.isDigit(Integer.parseInt(r1))) {
//                throw new NumberFormatException("Invalid expression");
//            }
//            else {
//                for (RomeNumbers r : rom) {
//                    if (r.name().equals(r1)) {
//                        checkResult = true;
//                    }
//
//
//                }
//            }

            for (RomeNumbers r : rom) {
                if (r.name().equals(r1)){
                    checkResult =true;
                    break;
                }
            }

            for (RomeNumbers r : rom) {
                if (r.name().equals(r2)) {
                    checkResult =true;
                    break;
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
            String withoutSymb =  text.replaceAll("[A-Za-z]*[-+*/]", "");
            String str = withoutSymb.replaceAll("( )+", " ");
            int index = str.indexOf(" ");
            if (str.startsWith("-")) {
                throw new ArithmeticException("Wrong statement!");
            }
            int a = Integer.parseInt(str.substring(0, index));
            int b = Integer.parseInt(str.substring(index + 1));
            if (b > 10 || a > 10) {
                throw new ArithmeticException("Numbers should be less then 10");
            }
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

        static boolean isNumber(String expression) {
            return expression.chars()
                    .anyMatch(Character::isDigit);
        }
}
