package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String returnNextMonth(){

        //Create date object
        Date dNow = new Date();

        //Create Calender object
        Calendar calendar = new GregorianCalendar();

        //Set Calendar date to current date
        calendar.setTime(dNow);

        //Create object of SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");

        //Implementing the current Month
        calendar.add(Calendar.MONTH, 1);

        //Generating the date based on the format
        return sdf.format(calendar.getTime());
    }
}
