package Person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {


    public static boolean isNameValid(String name) {
        if (name.matches("[a-zA-Z]+")) {
            if (name.length() <= 18) {
                return true;
            }
        }
        return false;
    }

    public static boolean stuIsEduNumberValid(String number){
        if (number.length() == 10 && number.matches("\\d+") ) return true;
           return false;
    }
    public static boolean TeacherIsEduNumberValid(String number){
        if (number.length() == 6 && number.matches("\\d+")) return true;
        return false;
    }
    public static boolean adminIsEduNumberValid(String number){
        if (number.length() == 4 && number.matches("\\d+")) return true;
        return false;
    }

    public static boolean isEmailValid(String email) {
        if (email.length()>18) return false;
        String emailRegex = "^[a-zA-Z0-9.]*@(?:[a-z0-9.-]+\\.)+[a-zA-Z]{1,4}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isUsernameValid(String username) {
        if (username.matches("[a-zA-Z0-9]+"))
            if ((username.length() > 4) && (username.length()<13) ) {
                return true;
            }
        return false;
    }

    public static boolean isPasswordValid(String password) {
        if (password.matches("[a-zA-Z0-9]+")) {
            if ((password.length() > 7) && (password.length() <13)) return true;
        }
        return false;
    }
    public static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.matches("^09\\d{9}$");
    }
}
