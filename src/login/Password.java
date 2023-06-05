package login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private final Pattern pattern;
    private static final String PASSWORD_PATTERN = "^[a-z0-9._-]{3,15}$";
    public Password(){
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }
    public boolean validatePassword(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
