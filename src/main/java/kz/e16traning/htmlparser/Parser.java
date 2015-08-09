package kz.e16traning.htmlparser;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser realisation.
 *
 */
public class Parser implements IParse {
    public void parseD() {
        Pattern fPattern = Pattern.compile("[Р|р](ис[.]|исунке)[ ][0-9]{1,2}([ ]?<|[ ]?&|,?[ ][а-я]{2,}|,[ ]?[0-9]{1,2}|[.]|[)]|.*?[)]| и [0-9]{1,2}|)");
        Pattern dPattern = Pattern.compile("\\d{1,2}");
        try {
            FileInputStream inF = new FileInputStream(FILE_FOR_PARSE);
            BufferedReader in = new BufferedReader(new InputStreamReader(inF, "cp1251"));
            int count = 1;
            String str = "";
            while ((str = in.readLine()) != null) {
                Matcher m = fPattern.matcher(str);
                while (m.find()) {
                    System.out.printf("%3d : %s\n", count++, m.group().trim());

                }
            }

            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void parseC() {
        Pattern fPattern = Pattern.compile("([(][Р|р]ис[.][ ]?[0-9]{1,2}.*?[)]|рисунке[ ][0-9]{1,2})");
        Pattern pPattern = Pattern.compile("рисунке[ ][0-9]{1,2}");
        Pattern dPattern = Pattern.compile("\\d{1,2}");
        try {
            FileInputStream inF = new FileInputStream(FILE_FOR_PARSE);
            BufferedReader in = new BufferedReader(new InputStreamReader(inF, "cp1251"));
            int count = 1;
            String str = "";
            while ((str = in.readLine()) != null) {
                Matcher m = fPattern.matcher(str);
                while (m.find()) {
                    System.out.printf("%3d : %s\n", count++, m.group().trim());

                }
            }

            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void parse() {
        Pattern fPattern = Pattern.compile("([Р|р]ис[.][ ]?[0-9]{1,2}(,[ ]?[0-9]{1,2}|[ ]и[ ][0-9]{1,2}|[ ][а-я][,][а-я]|[-][а-я][,][а-я]|[-][а-я]|[ ][а-я]|)|рисунке[ ][0-9]{1,2}([ ][(].*?[)]|))");
        Pattern pPattern = Pattern.compile("[а-д]");
        Pattern dPattern = Pattern.compile("([0-9]{1,2})");
        Map<Integer, String> ref = new LinkedHashMap<Integer, String>();
        try {
            FileInputStream inF = new FileInputStream(FILE_FOR_PARSE);
            BufferedReader in = new BufferedReader(new InputStreamReader(inF, "cp1251"));
            int count = 1;
            String str = "";
            while ((str = in.readLine()) != null) {
                Matcher m = fPattern.matcher(str);
                while (m.find()) {
                    String s = m.group().trim();
                    System.out.print(String.format("%3d : %s\n", count, s));
                    Matcher d = dPattern.matcher(s);
                    while (d.find()) {
                        Matcher p = pPattern.matcher(s);
                        String sd = d.group();
                        System.out.println(" - " + sd);
                        ref.put(count * 1000 + m.start(), sd);
                        int pCount = 0;
                        while(p.find()){
                            ref.put(count * 1000 + m.start() + pCount++, sd + p.group());
                            System.out.println(sd + p.group());
                        }
                    }
                }
                count++;
            }

            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Pattern kPattern = Pattern.compile("(pic[0-9]{1,2}[.]jpg)");
        Map<Integer, String> pic = new LinkedHashMap<Integer, String>();
        try {
            FileInputStream kinF = new FileInputStream(FILE_FOR_PARSE);
            BufferedReader kin = new BufferedReader(new InputStreamReader(kinF, "cp1251"));
            int count = 1;
            String str = "";
            while ((str = kin.readLine()) != null) {
                Matcher m = kPattern.matcher(str);
                while (m.find()) {
                    String s = m.group().trim();
                    System.out.print(String.format("%3d : %s\n", count, s));
                    pic.put(count * 1000 + m.start(), s.substring(0,s.length() - 4));
                }
                count++;
            }
            kin.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        /*for (Map.Entry<Integer, String> pair : ref.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }*/

        for (int i = 0; i < 20000000; i++) {
            if (ref.containsKey(i)) System.out.println(i + " : " + ref.get(i));
            if (pic.containsKey(i)) System.out.println(i + " : " + pic.get(i));
        }

    }


    public boolean isSuccessively() {
        return false;
    }

    public String[] getSentences() {
        return new String[0];
    }
}
