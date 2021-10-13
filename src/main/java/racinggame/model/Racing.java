package racinggame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nextstep.utils.Randoms;
import racinggame.enums.ErrorType;
import racinggame.exception.InputException;

public class Racing {

    public static final int MINIMUM_CAR = 2;
    private List<Car> cars;

    public Racing(String... args) {
        this.cars = new ArrayList<>();
        for(String carName : args){
            this.cars.add(new Car(carName));
        }
        if(cars.size() < MINIMUM_CAR){
            throw new InputException(ErrorType.ERROR_MINIMUM_CAR);
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void moveAll() {
        for(Car car : this.cars){
            move(car);
        }
        printAll();
    }

    public void move(Car car){
        int ranNo = Randoms.pickNumberInRange(0,9);
        car.move(ranNo);
    }

    public void printAll(){
        for(Car car : this.cars){
            car.printDistance();
        }
        System.out.println();
    }

    public void printWinner() {
        Collections.sort(cars);
        Winner winner = new Winner(cars);
        System.out.println("최종 우승자는 " + winner.getWinner() + " 입니다.");
    }


}
