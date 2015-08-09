package kz.e16traning.htmlparserv3;


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
public class Parser implements IParse{
    private ArrayList<Line> picLines = new ArrayList<Line>();
    private ArrayList<Line> refLines = new ArrayList<Line>();
    private Pattern picPattern = Pattern.compile("pic([0-9]{1,2})[.]jpg");
    private Pattern refPattern = Pattern.compile("[Р|р](ис[.]|исунке)[ ]?([0-9]{1,2})");

    private void parse(Pattern pattern, boolean isRef) {
        try {
            FileInputStream fin = new FileInputStream(FILE_FOR_PARSE);
            BufferedReader in = new BufferedReader(new InputStreamReader(fin, "cp1251"));
            int numberOfLine = 0;
            String str = "";
            while ((str = in.readLine()) != null) {
                Matcher m = pattern.matcher(str);
                numberOfLine++;
                if (m.find()) {
                    String line = m.group().trim();
                    //System.out.printf("%3d : %s\n", numberOfLine, line);
                    if (isRef) {
                        refLines.add(new Line(numberOfLine, str));
                    }
                    else {
                        picLines.add(new Line(numberOfLine, str));
                    }
                }
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void parseForRefs() {
        parse(refPattern, true);
    }

    public void parseForPics() {
        parse(picPattern, false);
    }

    public void printLines() {
        for (Line line : refLines) {
            System.out.println(line);
        }
        for (Line line : picLines) {
            System.out.println(line);
        }
    }

    public void getState() {
        for (Line line : refLines) {
            Matcher m = refPattern.matcher(line.getData());
            while (m.find()) {
                System.out.println(m.group(2));
                line.addRef(Integer.valueOf(m.group(2)));
            }
        }
        for (Line line : picLines) {
            Matcher m = picPattern.matcher(line.getData());
            if (m.find()) {
                System.out.println(m.group(1));
                line.setNumberOfPic(Integer.valueOf(m.group(1)));
            }
        }
    }

    public void checkForState() {
        for (Line line : refLines) {
            for (int i = 0; i < line.getRefs().size(); i++) {
                if (line.getNumberOfLine() < getNumbOfPicLine(line.getRefs().get(i)))
                    System.out.println("alarm " + line.getNumberOfLine() + " : " + line.getRefs().get(i) + " < " + getNumbOfPicLine(line.getRefs().get(i)));
                else System.out.println("ok");
            }
        }
    }

    private int getNumbOfPicLine(int numbOfPic) {
        for (Line line : picLines) {
            if (line.getNumberOfPic() == numbOfPic) return line.getNumberOfLine();
        }
        return 0;
    }

    public boolean isSuccessively() {
        return false;
    }

    public String[] getSentences() {
        return new String[0];
    }
}
