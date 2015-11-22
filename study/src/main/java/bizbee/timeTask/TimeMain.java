package bizbee.timeTask;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 *
 */
public class TimeMain {
    public static void main(String[] args) throws ParseException{
        Date date = new Date();
        System.out.println(date);

        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        formatter.setTimeZone(timeZone);
        System.out.println(formatter.format(date));

        Date superDate = formatter.parse("08/16/2011 12:10:10");

        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.getTime());

        calendar.add(Calendar.MONTH, -1);
        System.out.println(calendar.getTime());
    }
}
