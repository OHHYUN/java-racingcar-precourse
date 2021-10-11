package racinggame.utils;

import java.util.ArrayList;
import java.util.List;
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

    public static boolean isNameBlank(String carNames) {
        String regex = ",*[ ]+,+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(carNames);
        return matcher.find();
    }

    public static boolean isDuplicateNames(String carNames) {
        String[] carNameArr = carNames.split(",");
        List<String> carNameList = new ArrayList<>();
        for(int i =0; i<carNameArr.length; i++){
            inputCarName(carNameList, carNameArr[i]);
        }
        if(carNameArr.length==carNameList.size()){
            return false;
        }
        return true;
    }

    public static void inputCarName(List<String> carNameList, String carName){
        if(!carNameList.contains(carName)){
            carNameList.add(carName);
        }
    }
}
