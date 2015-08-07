package kz.e16traning.crazylogger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Логер через StringBuilder.
 *
 */
public class CrazyLogger {
    private static CrazyLogger instance;
    private static final Calendar calendar =
            Calendar.getInstance();
    private static final StringBuilder loggerData =
            new StringBuilder(1024);
    private SimpleDateFormat dateFormat =
            new SimpleDateFormat("dd.MM.yyyy hh:mm");

    private CrazyLogger() {}

    public static CrazyLogger getLogger() {
        if (instance == null) {
            instance = new CrazyLogger();
        }
        return instance;
    }

    public void log(String message) {
        loggerData.append(dateFormat.format(calendar.getTime()))
                .append(" - ").append(message).append("\n");
    }

    public void showLog() {
        System.out.println(loggerData.toString());
    }

    public void showLog(Date byDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        showLog(dateFormat.format(byDate));
    }

    public void showLog(String byString) {
        Pattern pattern = Pattern.compile(".*" + byString + ".*\\n");
        Matcher matcher = pattern.matcher(loggerData.toString());
        while (matcher.find()) {
            System.out.println(matcher.group().trim());
        }
    }

}
