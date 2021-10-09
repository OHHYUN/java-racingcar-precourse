package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

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

}
