package kz.e16traning.locale;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by X1 on 10.08.2015.
 */
public class Run {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("ru - 0 / en - 1");
        char choiceOfLang = 0;
        try {
            choiceOfLang = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] lang = {"RU", "RU"};
        if ("1".equals(choiceOfLang)) {
            lang[0] = "US";
            lang[1] = "EN";
        }
        Locale currentLocale = new Locale(lang[1], lang[0]);
        ResourceBundle rb = ResourceBundle.getBundle("property.text", currentLocale);
        String question1 = rb.getString("menu1.question1");
        String rquestion1 = new String(question1.getBytes("ISO-8859-1"), "UTF-8");
        String question2 = rb.getString("menu1.question1");
        String rquestion2 = new String(question2.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("1: " + rquestion1);
        System.out.println("2: " + rquestion2);

        try {
            choiceOfLang = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ("1".equals(choiceOfLang)) {
            System.out.println(rb.getString("menu1.answer1"));
        } else {
            System.out.println(rb.getString("menu1.answer2"));
        }
    }
}
