package encryptdecrypt;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operation = sc.nextLine();
        String txt = sc.nextLine();
        int key = sc.nextInt();

        String res = "";

        switch (operation){
            case "enc":
                res = ShiftAlg.encrypt(txt, key);
                break;
            case "dec":
                res = ShiftAlg.decrypt(txt, key);
                break;
        }

        System.out.println(res);
    }

//    public static char Encrypt(char letter, int key) {
//        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
//        char ret;
//        int idx = IntStream.range(0, alphabet.length).filter(i -> alphabet[i] == Character.toUpperCase(letter)).findFirst().orElse(-1);
//        if (Character.isUpperCase(letter)) {
//            ret = alphabet[(idx +key) % alphabet.length];
//        } else {
//            ret = alphabet[(idx + key) % alphabet.length];
//            ret = Character.toLowerCase(ret);
//        }
//        return ret;
//    }
}
