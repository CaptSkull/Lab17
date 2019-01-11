import java.io.IOException;
import java.util.List;

class Cezar {
    private final static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final static int alphSize = alphabet.length;
    private final static int firstLetter = alphabet[0];

    static List<char[]> crypt(String text, int shift) throws IOException {
        List<char[]> textList = Text.getTextList(text);
        return cryptAlgorithm(textList, shift);
    }

    private static List<char[]> cryptAlgorithm(List<char[]> textList, int shift) {
        for (char[] string : textList) {
            for (int i = 0; i < string.length; i++) {
                for (int b = 0, e = alphSize - 1; b < alphSize || e > 0; b++, e--) {
                    if (string[i] == alphabet[b] || string[i] == alphabet[e]) {
                        int indexL = string[i] - firstLetter;
                        int offset = (indexL + shift) % alphSize;
                        string[i] = alphabet[offset];
                        break;
                    }
                }
            }
        }
        return textList;
    }

    static List<char[]> decrypt(String text, int shift) throws IOException {
        return crypt(text, (alphSize - (shift % alphSize)));
    }
}
