package racinggame;

import static nextstep.utils.Randoms.*;

import java.util.ArrayList;
import java.util.List;

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
}
