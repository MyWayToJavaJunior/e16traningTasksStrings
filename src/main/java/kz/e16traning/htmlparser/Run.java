package kz.e16traning.htmlparser;

/**
 * @author DK
 * @version 1.0.0
 *
 */
public class Run {
    public static void main(String[] args) {
        SimpleParser parser = new SimpleParser();
        parser.parse();
        parser.outputLines();
    }
}
