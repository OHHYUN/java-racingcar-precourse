package racinggame.model;

public class CarName {

    public static final int LIMIT_CAR_NAME_DIGIT = 5;

    private String carName;

    public CarName(String carName){
        if(carName.length() > LIMIT_CAR_NAME_DIGIT){
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
        }
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }
}
