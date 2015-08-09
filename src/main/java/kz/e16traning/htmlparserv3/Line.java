package kz.e16traning.htmlparserv3;

import java.util.ArrayList;

/**
 * Created by X1 on 09.08.2015.
 */
public class Line {
    private int numberOfLine;
    private String data;
    private int numberOfPic;
    private ArrayList<Integer> refs;

    public Line(int numberOfLine, String data) {
        this.numberOfLine = numberOfLine;
        this.data = data;
        refs = new ArrayList<Integer>();
    }

    public void addRef(int ref) {
        refs.add(ref);
    }

    public void setNumberOfPic(int numberOfPic) {
        this.numberOfPic = numberOfPic;
    }

    public int getNumberOfPic() {
        return numberOfPic;
    }

    public ArrayList<Integer> getRefs() {
        if (!refs.isEmpty()) return refs;
        else return null;
    }

    public String getData() {
        return data;
    }

    public int getNumberOfLine() {
        return numberOfLine;
    }

    @Override
    public String toString() {
        return numberOfLine + " : " + data;
    }

}
