package racinggame;

import static nextstep.utils.Randoms.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nextstep.utils.Randoms;

public class Racing {

	private List<Car> cars;
	private StringBuilder winner = new StringBuilder(); // 일급 콜렉션에 다른걸 넣어도 되나??

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

	public void getWinner() {
		Collections.sort(this.cars);

		int winnersDistance = this.cars.get(0).getDistance();
		for(Car car : this.cars){
			isMax(car, winnersDistance);
		}
		System.out.println("최종 우승자는 " + winner.toString() + " 입니다.");

	}

	public void isMax(Car car, int max){
		if(car.getDistance() == max){
			winner.append(car.getCarName());
		}
	}

}
