import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String fullFileName = "Misery.txt";
        String chapterFileName = "Part.txt";
        List<char[]> cryptedText = Cezar.crypt(chapterFileName, 2);
        String cryptedChapterName = "Ccrypted";
        writeToFile(cryptedText, cryptedChapterName);
        List<char[]> decryptedText = Cezar.decrypt(cryptedChapterName, 2);
        writeToFile(decryptedText, "Cdecrypt.txt");
        List<char[]> freqDecryptedText = FreqAnalysis.decryprt(cryptedChapterName, fullFileName);
        writeToFile(freqDecryptedText, "Fdecrypt.txt");
    }
    private static void writeToFile(List<char[]> text, String name) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(name));
        for (char[] string : text)
            pw.println(string);
        pw.close();
    }
}


