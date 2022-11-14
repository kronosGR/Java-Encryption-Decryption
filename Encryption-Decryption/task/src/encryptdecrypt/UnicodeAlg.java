package encryptdecrypt;

public class UnicodeAlg extends Algorithm{
    @Override
    public  String encrypt(String txt, int key){
        String encrypted = "";
        for (char ch : txt.toCharArray()) {
            encrypted += (char) (ch + key);
        }

        return encrypted;
    }

    @Override
    public  String decrypt(String txt, int key){
        String encrypted = "";
        for (char ch : txt.toCharArray()) {
            encrypted += (char) (ch - key);
        }

        return encrypted;
    }
}
