package ru.aristovo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnpackString {

    public static void main(String[] args) throws IOException {

        //3[xyz]4[xy]z  = xyzxyzxyzxyxyxyxyz
        //2[3[x]y]      = xxxyxxxy

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строку для распаковки");
        String strEnter = reader.readLine(); // вводная строка
        reader.close();

        String strResult = ""; // строка, которая будет выведена на экран

        // преобразовываем строку в массив символов
        char[] arrChar = strEnter.toCharArray();

        int numQuantity = 0;
        String str = "";

        for (char c:arrChar) {
            if (Character.isDigit(c)) {
                numQuantity = Character.getNumericValue(c);
                continue;
            }
            if (Character.isLetter(c)) {
                if (numQuantity == 0) {
                    strResult += c;
                } else {
                    str += c;
                }
                continue;
            }
            if (c == '[') {
                continue;
            }
            if (c == ']') {
                for (int i = 0; i < numQuantity; i++) {
                    strResult += str;
                }
                numQuantity = 0;
                str = "";
                continue;
            }
        }
        System.out.println("Распакованная строка");
        System.out.println(strResult);

    }
}