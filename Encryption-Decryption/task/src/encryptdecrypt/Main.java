package encryptdecrypt;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        char[] chars = "we found a treasure!".toCharArray();

        StringBuilder res = new StringBuilder();

        for (char ch : chars) {
            if (Character.isLetter(ch)) {
                res.append(Encrypt(ch));
            } else {
                res.append(ch);
            }
        }

        System.out.println(res);
    }

    public static char Encrypt(char letter) {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char ret;
        int idx = IntStream.range(0, alphabet.length).filter(i -> alphabet[i] == Character.toUpperCase(letter)).findFirst().orElse(-1);
        if (Character.isUpperCase(letter)) {
            ret = alphabet[alphabet.length - 1 - idx];
        } else {
            ret = alphabet[alphabet.length - 1 - idx];
            ret = Character.toLowerCase(ret);
        }
        return ret;
    }
}
