package kz.e16traning.htmlparserv3;

/**
 * Created by X1 on 09.08.2015.
 */
public class Run {
    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.parseForPics();
        parser.parseForRefs();
        parser.printLines();
        parser.getState();
        parser.checkForState();
    }
}
