package racinggame.model;

import racinggame.ErrorType;
import racinggame.InputException;

public class CarName {

    public static final int LIMIT_CAR_NAME_DIGIT = 5;

    private String carName;

    public CarName(String carName){
        if(carName.length() > LIMIT_CAR_NAME_DIGIT){
            throw new InputException(ErrorType.ERROR_LIMIT_CAR_NAME);
        }
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }
}
