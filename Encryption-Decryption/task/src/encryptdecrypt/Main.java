package encryptdecrypt;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        int key = sc.nextInt();

        StringBuilder res = new StringBuilder();

        for (char ch : chars) {
            if (Character.isLetter(ch)) {
                res.append(Encrypt(ch, key));
            } else {
                res.append(ch);
            }
        }

        System.out.println(res);
    }

    public static char Encrypt(char letter, int key) {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char ret;
        int idx = IntStream.range(0, alphabet.length).filter(i -> alphabet[i] == Character.toUpperCase(letter)).findFirst().orElse(-1);
        if (Character.isUpperCase(letter)) {
            ret = alphabet[(idx +key) % alphabet.length];
        } else {
            ret = alphabet[(idx + key) % alphabet.length];
            ret = Character.toLowerCase(ret);
        }
        return ret;
    }
}
