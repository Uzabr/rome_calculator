package tests;


import org.junit.jupiter.api.Test;
import run.Main;
import symbols.Symbol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCalculator {

        @Test
        public void testArabicAddition() throws Exception {
            assertEquals("15", Main.calc("10 + 5"));
        }

        @Test
        public void testRomanAddition() throws Exception {

            assertEquals("XV", Main.calc("V + X"));
        }

        @Test
        public void testArabicSubtraction() throws Exception {
            assertEquals("7", Main.calc("10 - 3"));
        }

        @Test
        public void testRomanSubtraction() throws Exception {
            assertEquals("V", Main.calc("X - V"));
        }

        @Test
        public void testArabicMultiplication() throws Exception {
            assertEquals("30", Main.calc("5 * 6"));
        }

        @Test
        public void testRomanMultiplication() throws Exception {
            assertEquals("XC", Main.calc("X * IX"));
        }

        @Test
        public void testArabicDivision() throws Exception {
            assertEquals("4", Main.calc("20 / 5"));
        }

        @Test
        public void testRomanDivision() throws Exception {
            assertEquals("II", Main.calc("X / V"));
        }

        @Test
        public void testInvalidInput() {
            ArithmeticException exception = assertThrows(ArithmeticException.class, () ->
                    Main.calc("3 + II"));
            assertEquals("Invalid input", exception.getMessage());
        }


        @Test
        public void testRomanResultLessThanOne() {
            ArithmeticException exception = assertThrows(ArithmeticException.class, () ->
                    Main.calc("I - II"));
            assertEquals("Result cannot be less than 1 for Roman numerals", exception.getMessage());
        }

        @Test
        public void testDivisionByZero() {
            ArithmeticException exception = assertThrows(ArithmeticException.class, () ->
                    Main.calc("5 / 0"));
            assertEquals("/ by zero", exception.getMessage());
        }
    }
