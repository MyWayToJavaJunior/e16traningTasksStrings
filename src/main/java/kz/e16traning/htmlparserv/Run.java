package kz.e16traning.htmlparserv;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DK
 * @version 1.0.0
 *
 */
public class Run {
    public static void main(String[] args) {
        List<Line> refLines = new ArrayList<Line>();
        List<Line> picLines = new ArrayList<Line>();
        Parser parser = new Parser();
        parser.parse(refLines, picLines);
        parser.setState(refLines, picLines);
        printLines(refLines);
        printLines(picLines);
    }

    public static void printLines(List<Line> lines) {
        for (Line line : lines) {
            System.out.println(line);
        }
    }
}
