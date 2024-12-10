import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class Main {

    String num;

    public String booleanToYN(Boolean value) {
        String s = "";
        if (value != null) {
            if (value)
                s = "Y";
            else {
                s = "N";
            }
        }
        return s;
    }

    // Define the regex pattern for Namibian phone numbers
    private static final String NAMIBIAN_PHONE_PATTERN = "^\\+264 (60|81|82|83|84|85){3} {4}$";

    public static boolean isValidNamibianNumber(String number) {
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(NAMIBIAN_PHONE_PATTERN);
        // Match the input number against the pattern
        Matcher matcher = pattern.matcher(number);
        // Return whether the number matches the pattern
        return matcher.matches();
    }




    public static void main2(String[] args) {

        String number = "+27814659069";

        if(number.startsWith("+27")) {

            number = number.replace("+27","0");
        }
        out.println(number.length());



    }
}