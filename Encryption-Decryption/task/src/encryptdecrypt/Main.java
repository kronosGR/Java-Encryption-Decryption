package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String operation = "enc";
        String txt = null;
        int key = 0;
        String in = null;
        String out = null;

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            String argValue = args[++i];

            switch (arg) {
                case ("-mode"):
                    operation = argValue;
                    break;
                case ("-key"):
                    key = Integer.parseInt(argValue);
                    break;
                case ("-data"):
                    txt = argValue;
                    break;
                case "-in":
                    in = argValue;
                    break;
                case "-out":
                    out = argValue;
                    break;

            }
        }

        String res = "";
        if (txt == null && in == null) {
            txt = "";
        } else if (txt == null) {
            // read from file
            txt = readFile(in);
        }

        switch (operation) {
            case "enc":
                res = ShiftAlg.encrypt(txt, key);
                break;
            case "dec":
                res = ShiftAlg.decrypt(txt, key);
                break;
        }

        if (out == null) {
            System.out.println(res);
        } else {
            // write result to file
            writeFile(out, res);
        }
    }

    public static String readFile(String file) {
        try (Scanner sc = new Scanner(new File(file))) {
            String text = "";
            while (sc.hasNextLine()) {
                text += sc.nextLine();
            }
            return text;
        } catch (FileNotFoundException e) {
            return "";
        }
    }

    public static void writeFile(String file, String txt) {
        try (FileWriter wr = new FileWriter(file)) {
            wr.write(txt);
            wr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
