package kz.e16traning.htmlparser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser realisation.
 *
 */
public class SimpleParser implements IParse{
    private ArrayList<Line> lines = new ArrayList<Line>();

    public void parse() {
        Pattern fPattern = Pattern.compile("(<div>)(.*)(</div>)");
        try {
            FileInputStream inF = new FileInputStream(FILE_FOR_PARSE);
            BufferedReader in = new BufferedReader(new InputStreamReader(inF, "cp1251"));
            int numberOfLine = 0;
            String str = "";
            while ((str = in.readLine()) != null) {
                Matcher m = fPattern.matcher(str);
                numberOfLine++;
                while (m.find()) {
                    String line = m.group(2).trim();
                    System.out.printf("%3d : %s\n", numberOfLine, line);
                    lines.add(new Line(numberOfLine, line));
                }
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void outputLines() {
        for (Line line : lines) {
            System.out.println(line.getNumberOfLine() + " : " +line.getSentences().size() + " : " +line.getNumbOfPic() + " : " + line.getData());
            for (String string : line.getSentences()) {
                System.out.println(string);
            }
        }
    }


    public boolean isSuccessively() {
        return false;
    }

    public String[] getSentences() {
        return new String[0];
    }
}
