package kz.e16traning.locale;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author DK
 * @version 1.0.0
 *
 */
public class Run {
    private static ResourceBundle rb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("ru - 0 / en - 1");
            String[] lang = {"RU", "RU"};
            if ("1".equals(sc.nextLine())) {
                lang[0] = "US";
                lang[1] = "en";
            }
            Locale currentLocale = new Locale(lang[1], lang[0]);
            rb = ResourceBundle.getBundle("property.text", currentLocale);
            System.out.println("1: " + getPropByKey("menu1.question1"));
            System.out.println("2: " + getPropByKey("menu1.question2"));
            System.out.println("1 / 2");
            if ("1".equals(sc.nextLine())) {
                System.out.println(getPropByKey("menu1.answer1"));
            } else {
                System.out.println(getPropByKey("menu1.answer2"));
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Кодировка не поддерживается");
        } finally {
            sc.close();
        }
    }
    public static String getPropByKey(String key) throws UnsupportedEncodingException {
        return new String(rb.getString(key).getBytes("ISO-8859-1"), "UTF-8");
    }
}
