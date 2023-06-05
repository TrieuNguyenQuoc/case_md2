package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static final String id = "^[0-9*]+$";

    public static boolean validateId(String ids) {
        Pattern pattern = Pattern.compile(id);
        Matcher matcher = pattern.matcher(ids);
        return matcher.matches();
    }
}
