package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void 자동차_전진() {
		Car car = new Car("Tony");
		car.move(4);
		car.move(9);
		assertThat(car.getDistance()).isEqualTo(2);
	}

	@Test
	void 자동차_멈춤() {
		Car car = new Car("Tony");
		car.move(3);
		car.move(0);
		assertThat(car.getDistance()).isEqualTo(0);
	}
}
