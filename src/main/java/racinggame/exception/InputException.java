package racinggame.exception;

import racinggame.model.ErrorType;

public class InputException extends IllegalArgumentException{

    public InputException(ErrorType errorType){
        super(errorType.getErrMsg());
        errorType.printErrMsg();
    }

}
