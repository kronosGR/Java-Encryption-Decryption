package encryptdecrypt;

abstract public class Algorithm {
    public abstract String encrypt(String text, int key);
    public abstract String decrypt(String text, int key);
}
