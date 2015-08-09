package kz.e16traning.htmlparserv;

import java.util.ArrayList;
import java.util.List;

/**
 * Line of parsed text.
 *
 */
public class Line {
    private int numbOfLine;
    private String data;
    private List<Integer> numbOfPics;
    private boolean isRefPrevPic;

    public Line(int numbOfLine, String data) {
        this.numbOfLine = numbOfLine;
        this.data = data;
        this.numbOfPics = new ArrayList<Integer>();
    }

    public void addNumbOfPic(int numbOfPic) {
        this.numbOfPics.add(numbOfPic);
    }

    public String getData() {
        return data;
    }

    public List<Integer> getNumbOfPics() {
        return numbOfPics;
    }

    public int getNumbOfLine() {
        return numbOfLine;
    }

    public void setRefPrevPic() {
        isRefPrevPic = true;
    }

    @Override
    public String toString() {
        return numbOfLine + (isRefPrevPic ? " Ref prev pic" : "") + " : "  + numbOfPics.toString() + " : " + data;
    }

}
