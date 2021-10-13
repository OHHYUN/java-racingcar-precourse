package racinggame.enums;

public enum ErrorType {
    ERROR_CONSECUTIVE_COMMA("[ERROR] 연속된 콤마(,) 가 있습니다."),
    ERROR_LAST_COMMA_BLANK("[ERROR] 마지막 자동차 이름이 없습니다."),
    ERROR_NAME_BLANK("[ERROR] 공백인 자동차의 이름이 있습니다."),
    ERROR_DUPLICATE_NAME("[ERROR] 중복된 이름을 갖는 자동차가 있습니다."),
    ERROR_LIMIT_CAR_NAME("[ERROR] 자동차의 이름은 5글자 이하여야 합니다."),
    ERROR_MINIMUM_CAR("[ERROR] 최소 2대 이상 입력해주세요."),
    ERROR_ONLY_NUMBER("[ERROR] 숫자만 입력해주세요."),
    ERROR_TOO_BIG_NUMBER("[ERROR] 너무 큰 숫자입니다.")
    ;


    private String errMsg;

    public String getErrMsg(){
        return this.errMsg;
    }

    public void printErrMsg(){
        System.out.println(this.errMsg);
    }

    ErrorType(String errMsg){
        this.errMsg = errMsg;
    }

}
