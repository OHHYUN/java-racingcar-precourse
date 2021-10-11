package racinggame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

import nextstep.utils.Randoms;

public class Racing {

    private List<Car> cars;

    public Racing(String... args) {
        this.cars = new ArrayList<>();
        for(String carName : args){
            this.cars.add(new Car(carName));
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
    }

    public void printWinner() {
        Collections.sort(cars);
        Winner winner = new Winner(cars);
        System.out.println("최종 우승자는 " + winner.getWinner() + " 입니다.");
    }


}
