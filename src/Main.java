import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Вариант No1, 7, 13, 19, 25
 *В программу передается текст из файла. В этом тексте должно быть подсчитано количество
 *прилагательных, наречий и глаголов.
 */
public class Main
{
    public static void main(String[] args) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("test"), StandardCharsets.UTF_8);
            } catch (IOException e) {
            e.printStackTrace();
            }
        int pril, glag, nar;
        for(String line: lines)
        {
        }
    }
}