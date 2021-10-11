package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racinggame.utils.InputValidUtils;

public class inputUtilTest {
    private PrintStream standardOut = System.out;
    private OutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void beforeEach(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 쉼표_연속_검증() {
        String carNames = "이거,저거,조고,,네번째글자";
        boolean isConsecutiveComma = InputValidUtils.isConsecutiveComma(carNames);
        assertThat(isConsecutiveComma).isTrue();
    }

    protected void outputStandard() {
        System.setOut(standardOut);
        System.out.println(outputStream.toString());
    }
    @AfterEach
    void tearDown() {
        outputStandard();
    }

    private void command(final String... args) {
        final byte[] buf = Strings.join(args).with("\n").getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
