package racinggame;

public class InputException extends IllegalArgumentException{

    public InputException(ErrorType errorType){
        super(errorType.getErrMsg());
        System.out.println(errorType.getErrMsg());
    }

}
