package racinggame.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import racinggame.ErrorType;
import racinggame.InputException;

public class InputValidUtils {

    public static final String CONSECUTIVE_COMMA = "(,){2,}";
    public static final String LAST_COMMA_BLANK = ",[ ]*?$";
    public static final String NAME_BLANK = ",*[ ]+,+";
    public static final String COMMA = ",";

    public static boolean isConsecutiveComma(String carNames) {
        Pattern pattern = Pattern.compile(CONSECUTIVE_COMMA);
        Matcher matcher = pattern.matcher(carNames);
        throwInputError(matcher.find(), ErrorType.ERROR_CONSECUTIVE_COMMA);
        return false;
    }

    public static boolean isLastCommaBlank(String carNames) {
        Pattern pattern = Pattern.compile(LAST_COMMA_BLANK);
        Matcher matcher = pattern.matcher(carNames);
        throwInputError(matcher.find(), ErrorType.ERROR_LAST_COMMA_BLANK);
        return false;

    }

    public static boolean isNameBlank(String carNames) {
        Pattern pattern = Pattern.compile(NAME_BLANK);
        Matcher matcher = pattern.matcher(carNames);
        throwInputError(matcher.find(), ErrorType.ERROR_NAME_BLANK);
        return false;
    }

    public static boolean isDuplicateNames(String carNames) {
        String[] carNameArr = carNames.split(COMMA);
        List<String> carNameList = new ArrayList<>();
        for(int i =0; i<carNameArr.length; i++){
            inputCarName(carNameList, carNameArr[i]);
        }
        if(carNameArr.length!=carNameList.size()){
            throwInputError(true, ErrorType.ERROR_DUPLICATE_NAME);
        }
        return false;
    }

    public static void inputCarName(List<String> carNameList, String carName){
        if(!carNameList.contains(carName)){
            carNameList.add(carName);
        }
    }

    public static void throwInputError(boolean match, ErrorType errorType){
        if(match){
            throw new InputException(errorType);
        }
    }

}
