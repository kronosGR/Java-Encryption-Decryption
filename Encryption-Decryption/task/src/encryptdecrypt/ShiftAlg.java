package encryptdecrypt;

public class ShiftAlg extends Algorithm {
    @Override
    public String encrypt(String text, int key) {
        String retText = "";
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char newCh = (char) (ch + key);
                if (Character.isUpperCase(ch)) {
                    if (newCh > 'Z') {
                        retText += (char) (newCh % 'Z' + 'A' - 1);
                    } else {
                        retText += newCh;
                    }
                } else {
                    if (newCh > 'z') {
                        retText += (char) (newCh % 'z' + 'a' - 1);
                    } else {
                        retText += newCh;
                    }
                }
            } else {
                retText += ch;
            }
        }
        return retText;
    }

    @Override
    public String decrypt(String text, int key) {
        String retText = "";
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char newCh = (char) (ch - key);
                if (Character.isUpperCase(ch)) {
                    if (newCh < 'A') {
                        retText += (char) ('Z' + 1 + newCh - 'A');
                    } else {
                        retText += newCh;
                    }
                } else {
                    if (newCh < 'a') {
                        retText += (char) ('z' + 1 + newCh - 'a');
                    } else {
                        retText += newCh;
                    }
                }
            } else {
                retText += ch;
            }
        }
        return retText;
    }
}
