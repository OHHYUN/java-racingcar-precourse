package racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class RacingTest {
	private PrintStream standardOut = System.out;
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

	@Test
	void 여러개의_자동차의_전진() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(4)
				.thenReturn(3)
				.thenReturn(9);
			Racing racing = new Racing("이거","저거","조고");
			racing.moveAll();
			assertThat(outputStream.toString().trim()).contains("이거 : -", "저거 : ", "조고 : -");
		}
	}

	protected void outputStandard() {
		System.setOut(standardOut);
		System.out.println(outputStream.toString());
	}
	@AfterEach
	void tearDown() {
		outputStandard();
	}
}
