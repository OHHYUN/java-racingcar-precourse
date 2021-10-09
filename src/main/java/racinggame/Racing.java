package racinggame;

import java.util.ArrayList;
import java.util.List;

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
}
