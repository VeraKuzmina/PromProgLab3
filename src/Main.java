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
    private final static String PRIL_PAT = "[а-яА-Я]{2,}(ый|ий|ого|его|ому|ему|ым|им|ом|ем" +
            "|ая|яя|ой|ей|ую|юю|оу|ее|ые|ых|ым|ие|ич|им|ыми|ими)[ .,?)!]";
    private final static String GLAG_PAT = "[а-яА-Я]{2,}(ем|ешь|ете|ет|ут|ют|им|ишь|ите|ит|ат|ят"+
        "|л|ла|ло|ли|ть)([ .,?)!]|(ся))";
    private final static String NAR_PAT = "[а-яА-Я]{2,}(о|а)[ .,?)!]";

    public static void main(String[] args) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("Bulgakov_The_White_Guard"));
            } catch (IOException e) {
            e.printStackTrace();
            }
        if (lines == null) System.exit(1);

        Pattern ppril = Pattern.compile(PRIL_PAT);
        Pattern pglag = Pattern.compile(GLAG_PAT);
        Pattern pnar = Pattern.compile(NAR_PAT);

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