package kz.e16traning.htmlparserv2;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by X1 on 09.08.2015.
 */
public class SimpleParser implements IParse{
    private Line tline = new Line(0,"asd");
    public void parse() {
        Pattern linePattern = Pattern.compile("(<div>)(.*)(</div>)");
        try {
            FileInputStream inF = new FileInputStream(FILE_FOR_PARSE);
            BufferedReader in = new BufferedReader(new InputStreamReader(inF, "cp1251"));
            int numberOfLine = 1;
            String str = "";
            while ((str = in.readLine()) != null) {
                Matcher m = linePattern.matcher(str);
                while (m.find()) {
                    String line = m.group(2).trim();
                    //System.out.printf("%3d : %s\n", numberOfLine++, line);
                    tline.addLine(new Line(numberOfLine++, line));
                }
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void output() {
        printList(tline.getLines());
    }

    public void outputPic() {
        printList(tline.getPicLines());
    }

    private void printList(ArrayList<Line> lines) {
        for (Line line : lines) {
            System.out.println(line);
        }
    }

    public boolean isSuccessively() {
        return false;
    }

    public String[] getSentences() {
        return new String[0];
    }
}
