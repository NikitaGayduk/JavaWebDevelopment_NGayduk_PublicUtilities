package by.epam.javawebtraining.gayduknikita.webproject.util;

import java.sql.Timestamp;

/**
 * @author NikitaGayduk
 * @date 26.05.2019
 */
public class TimestampBuilder {

    public static Timestamp createTimestamp(String date, String time) {
        if (date.equals("") || time.equals("")){
            return null;
        }

        String timestamp = date + " " + time + ":00";


        return Timestamp.valueOf(timestamp);
    }
}
