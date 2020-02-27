package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    String[] Rome = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[] Arab = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    String[] Op = {"+", "-", "*", "/"};


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        Check x = new Check();
        String num1, num2, op;
        int k = x.checkError(input);

        if (k == 1)
            x.RomeToArab();

        Calc c = new Calc(Integer.parseInt(x.num1), x.operation, Integer.parseInt(x.num2));
        int result = c.calculate();



        if (k == 1)
            System.out.println(ArabToRome.RomanNumerals(result));
        else
            System.out.println(result);

    }


}


class Check {
    String[] Arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[] Rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    String[] Op = {"+", "-", "*", "/"};

    public String num1;
    public String num2;
    public String operation;


    int checkError(String x) {
        try {
            String[] in = x.split(" ");
            int rome = 0;
            int arab = 0;
            int op = 0;


            for (String i : Arab) {
                if (i.equals(in[0])) arab += 1;

                if (i.equals(in[2])) arab += 1;

            }
            for (String i : Rome) {
                if (i.equals(in[0])) rome += 1;

                if (i.equals(in[2])) rome += 1;
            }
            for (String i : Op) {
                if (i.equals(in[1])) {
                    op++;
                }
            }

            num1 = in[0];
            num2 = in[2];
            operation = in[1];

            if (rome == 2 && op == 1) {
                return 1;
            }
            if (arab == 2 && op == 1) {
                return 2;
            }
            throw new Exception("Error Input!");
        } catch (Exception e) {
            System.out.println("Error!!!");
        }
        return 0;
    }

    void RomeToArab() {
        for (int i = 0; i < Rome.length; ++i) {
            if (Rome[i].equals(num1)) {
                num1 = Arab[i];
            }
            if (Rome[i].equals(num2)) {
                num2 = Arab[i];
            }
        }

    }

}

class ArabToRome {
    public static String RomanNumerals(int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for (Map.Entry<String, Integer> entry : roman_numerals.entrySet()) {
            int matches = Int / entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }

    public static String repeat(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}


class Calc {
    public int a;
    public int b;
    public String op;

    int calculate() {
        int result = 0;
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                if (a % b == 0)
                    result = a / b;
                else
                    result = 0;
                break;
            case "*":
                result = a * b;
                break;

        }
        return result;
    }

    Calc(int a, String op, int b) {
        this.a = a;
        this.b = b;
        this.op = op;

    }

}