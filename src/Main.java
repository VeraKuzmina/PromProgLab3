import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            lines = Files.readAllLines(Paths.get("Bulgakov_The_White_Guard"));
            } catch (IOException e) {
            e.printStackTrace();
            }
        Pattern ppril = Pattern.compile("[а-яА-я](ый|ий|ого|его|ому|ему|ым|им|ом|ем" +
                "|ая|яя|ой|ей|ую|юю|оу|ее|ые|ых|ым|ие|ич|им|ыми|ими)[ .,?)!]");
        Pattern pglag = Pattern.compile("[а-яА-я](ем|ешь|ете|ет|ут|ют|им|ишь|ите|ит|ат|ят"+
                "|л|ла|ло|ли)[ .,?)!]");
        Pattern pnar = Pattern.compile("[а-яА-я]{2,}(о|а)[ .,?)!]");
        Matcher m;
        int pril=0, glag=0, nar=0;
        for(String line: lines){
            m = ppril.matcher(line);
            while (m.find()) pril ++;
            m = pnar.matcher(line);
            while(m.find()) nar++;
            m = pglag.matcher(line);
            while (m.find()) glag ++;
        }
        System.out.println("Прилагательных: " + pril);
        System.out.println("Наречий: " + nar);
        System.out.println("Глаголов: " + glag);
    }
}