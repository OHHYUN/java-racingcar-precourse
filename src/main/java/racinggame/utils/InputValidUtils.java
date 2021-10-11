package racinggame.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidUtils {

    public static boolean isConsecutiveComma(String carNames) {
        String regex = "(,){2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(carNames);
        return matcher.find();
    }

    public static boolean isLastCommaBlank(String carNames) {
        String regex = ",[ ]*?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(carNames);
        return matcher.find();
    }
}
