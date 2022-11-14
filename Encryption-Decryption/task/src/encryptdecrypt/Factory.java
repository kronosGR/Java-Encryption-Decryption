package encryptdecrypt;

public class Factory {
    Algorithm useAlgo(String algo){
        switch (algo){
            case "unicode":
                return new UnicodeAlg();
            case "shift":
                return new ShiftAlg();
            default:
                return null;
        }
    }
}
