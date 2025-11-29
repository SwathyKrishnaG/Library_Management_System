package ie.tus.library.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String fmt(LocalDate d) {
        return d == null ? "null" : d.format(DateTimeFormatter.ISO_DATE);
    }
}
