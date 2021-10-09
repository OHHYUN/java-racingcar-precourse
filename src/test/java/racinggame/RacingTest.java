package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingTest {

	private OutputStream outputStream = new ByteArrayOutputStream();

	@BeforeEach
	void beforeEach(){
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	void 여러개의_자동차_생성() {
		Racing racing = new Racing("이거","저거","조고");
		List<Car> cars = racing.getCars();
		assertThat(cars.size()).isEqualTo(3);
	}

}
