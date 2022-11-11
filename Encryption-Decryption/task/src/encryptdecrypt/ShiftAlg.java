package encryptdecrypt;

public class ShiftAlg {

    public static String encrypt(String txt, int key){
        String encrypted = "";
        for (char ch : txt.toCharArray()) {
            encrypted += (char) (ch + key);
        }

        return encrypted;
    }

    public static String decrypt(String txt, int key){
        String encrypted = "";
        for (char ch : txt.toCharArray()) {
            encrypted += (char) (ch - key);
        }

        return encrypted;
    }
}
