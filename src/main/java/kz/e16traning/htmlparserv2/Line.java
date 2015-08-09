package kz.e16traning.htmlparserv2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by X1 on 09.08.2015.
 */
public class Line {
    private int numbOfLine;
    private  boolean isLineOfPic;
    private int numbOfPic;
    private String text;
    private ArrayList<Line> data;
    private Pattern picPattern = Pattern.compile("pic[0-9]{1,2}[.]jpg");
    private ArrayList<Sentence> sentences;


    public Line(int numbOfLine, String text) {
        this.numbOfLine = numbOfLine;
        this.text = text;
        Matcher picMatcher = picPattern.matcher(text);
        data = new ArrayList<Line>();
        if (picMatcher.find()) {
            isLineOfPic = true;
            numbOfPic = setNumberOfPic();
        }
        sentences = new ArrayList<Sentence>();
    }

    public void addLine(Line line) {
        data.add(line);
    }

    public ArrayList<Line> getLines() {
        return data;
    }

    public ArrayList<Line> getPicLines() {
        ArrayList<Line> result = new ArrayList<Line>();
        for (Line line : data) {
            if (line.isLineOfPic) result.add(line);
        }
        return result;
    }

    private int setNumberOfPic() {
        Pattern pattern = Pattern.compile("([0-9]{1,2}).jpg");
        Matcher matcher = pattern.matcher(text);
        matcher.find();
        return Integer.valueOf(matcher.group(1));
    }

    @Override
    public String toString() {
        return numbOfLine + " : " + text;
    }

}
