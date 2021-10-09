package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;

public class CarTest {

	private OutputStream outputStream = new ByteArrayOutputStream();

	@BeforeEach
	void beforeEach(){
		System.setOut(new PrintStream(outputStream));
	}

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

	@Test
	void 자동차_현재_거리_출력(){
		Car car = new Car("Tony");
		car.move(4);
		car.printDistance();
		assertThat(outputStream.toString().trim()).isEqualTo("Tony : -");
	}

	@Test
	void 여러개의_자동차_생성() {
		Racing racing = new Racing("이거","저거","조고");
		List<Car> cars = racing.getCars();
		assertThat(cars.size()).isEqualTo(3);
	}

}
