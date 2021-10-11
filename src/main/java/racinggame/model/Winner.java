package racinggame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Winner {

    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public String getWinner(){
        int winnersDistance = cars.get(0).getDistance();
        StringJoiner winners = new StringJoiner(",");
        List<Car> winnerCars = new ArrayList<>(cars);
        for(Car car : winnerCars){
            getMaxCarName(car, winnersDistance);
        }
        for(Car car : cars){
            winners.add(car.getCarName());
        }
        return winners.toString();
    }

    public void getMaxCarName(Car car, int max){
        if(car.getDistance() != max){
            cars.remove(car);
        }
    }
}
