package kz.e16traning.htmlparser;



import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Line of parsed text.
 *
 */
public class Line {
    private Pattern refPattern = Pattern.compile("[Р|р](ис[.]|исунке)[ ]?[0-9]{1,2}");
    private Pattern picPattern = Pattern.compile("pic[0-9]{1,2}[.]jpg");
    private Pattern sentencePattern = Pattern.compile("([А-ЯA-Z]((т.п.|т.д.|пр.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!])"); //([А-ЯA-Z]((т.п.|т.д.|пр.)|[^?!.\(]|\([^\)]*\))*[.?!]) ([А-Я][а-я]+?.*?([!?]|$|[.]))
    private boolean isPicOrRef;
    private boolean isPic;
    private int numbOfPic;
    private int numberOfLine;
    private String data;
    private ArrayList<String> sentences = new ArrayList<String>();
    private Integer[] numbersOfRefs;

    public Line(int numberOfLine, String data) {
        this.numberOfLine = numberOfLine;
        this.data = data;
        Matcher picMatcher = picPattern.matcher(data);
        if (picMatcher.find()) {
            isPic = true;
            numbOfPic = setNumberOfPic();
        }
        else {
            Matcher refMatcher = refPattern.matcher(data);
            if (refMatcher.find()) isPicOrRef = true;
        }
        if (isPicOrRef && !isPic) setSentence();
    }

    private void setNumbersOfRefs() {
        numbersOfRefs = new Integer[sentences.size()];
        Pattern pattern = Pattern.compile("[0-9]{1,2}");
        for (String string : sentences) {

        }
    }

    private void setSentence() {
        Matcher sentenceMatcher = sentencePattern.matcher(data);
        while (sentenceMatcher.find()) {
            sentences.add(sentenceMatcher.group());
        }
        setNumbersOfRefs();
    }

    public int getNumberOfLine() {
        return numberOfLine;
    }

    public String getData() {
        return data;
    }

    public ArrayList<String> getSentences() {
        return sentences;
    }

    private int setNumberOfPic() {
        Pattern pattern = Pattern.compile("([0-9]{1,2}).jpg");
        Matcher matcher = pattern.matcher(data);
        matcher.find();
        return Integer.valueOf(matcher.group(1));
    }

    public int getNumbOfPic() {
        return numbOfPic;
    }
}
