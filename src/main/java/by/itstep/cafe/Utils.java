package by.itstep.cafe;

public final class Utils {
//TODO move to service
    public static final String TEXT_PATTERN = "[A-Za-z]+";
    public static final String LOGIN_PATTERN = "[\\w]+";
    public static final String PHONE_PATTERN =
            "\\+[0-9]{2,3}-[0-9]{2}-[0-9]{7}";
    private static final String EMAIL_PATTERN = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}";

    public static boolean isText(String text) {
        if (text == null) return false;
        return text.matches(TEXT_PATTERN);
    }

    public static boolean isPhone(String phone){
        return phone.matches(PHONE_PATTERN);
    }

    public static boolean isEmail(String email){
        return email != null && email.matches(EMAIL_PATTERN);
    }

    public static boolean isLogin(String login) { return login != null && login.matches(LOGIN_PATTERN); }
}
