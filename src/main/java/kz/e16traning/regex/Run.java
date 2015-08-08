package kz.e16traning.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author DK
 * @version 1.0.0
 *
 */
public class Run {
    private final static String INPUT_STRING = "adjyaTs41245 Ashd 21344 sd 5h 512 h12khjh kjh1241T245a sd Fhr2g5dfg asdj qWaKedFgqWaKe qWaKe w qd DHWm Hd1gmwadaa";
    public static void main(String[] args) {
        Pattern[] patterns = {Pattern.compile("\\d{4}"), Pattern.compile("[0-9]{2}[a-z]{2}"),
                Pattern.compile("[a-zA-Z]{4}"), Pattern.compile("\\d+"),
                Pattern.compile("[A-Z][a-z]+"), Pattern.compile("[0-9][a-z]+"),
                Pattern.compile("[a-zA-Z][0-9]"), Pattern.compile("[0-9][a-zA-Z][0-9][a-zA-Z]"),
                Pattern.compile("[1]\\w+[a]"), Pattern.compile("\\bqWaKe\\b")};
        System.out.println("in string: (" + INPUT_STRING + ")\n");
        int count = 1;
        for (Pattern pattern : patterns) {
            Matcher m = pattern.matcher(INPUT_STRING);
            System.out.printf("%3d : pattern %-28.60s", count++, pattern.toString());
            System.out.print(" ( ");
            while (m.find()) {
                System.out.print(m.group() + " ");
            }
            System.out.print(")\n");
        }
    }
}
