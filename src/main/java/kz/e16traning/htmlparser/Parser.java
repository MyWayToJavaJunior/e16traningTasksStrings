package kz.e16traning.htmlparser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser realisation.
 *
 */
public class Parser implements IParse {

    public void parse() {
        Pattern fPattern = Pattern.compile("[Р|р](ис[.]|исунке)[ ][0-9]{1,2}(, [0-9]{1,2}|,[0-9]{1,2}|[.]| и [0-9]{1,2}| )");
        Pattern sPattern = Pattern.compile("[Р|р](ис[.]|исунке)[ ][0-9]");
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



    public boolean isSuccessively() {
        return false;
    }

    public String[] getSentences() {
        return new String[0];
    }
}
