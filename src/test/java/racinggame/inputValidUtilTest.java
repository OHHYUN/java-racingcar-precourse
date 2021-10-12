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

import racinggame.model.CarName;
import racinggame.utils.InputValidUtils;

public class inputValidUtilTest {
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

    @Test
    void 마지막_쉼표_공백() {
        String carNames = "이거,저거,조고, ";
        boolean isLastCommaBlank = InputValidUtils.isLastCommaBlank(carNames);
        assertThat(isLastCommaBlank).isTrue();
    }

    @Test
    void 공백만_있는_이름() {
        String carNames = "  ,이거,   ,저거,   ,조고";
        boolean isNameBlank = InputValidUtils.isNameBlank(carNames);
        assertThat(isNameBlank).isTrue();
    }

    @Test
    void 이름_중복_확인() {
        String carNames = "이거,이거,저거,저거,조고,저거";
        boolean isDuplicateNames = InputValidUtils.isDuplicateNames(carNames);
        assertThat(isDuplicateNames).isTrue();
    }

    @Test
    void 다섯글자_이상_검증() {
        String sixDigit = "다섯번째글자";

        assertThatIllegalArgumentException().isThrownBy(()->{
            new CarName(sixDigit);
        }).withMessage("[ERROR] 자동차의 이름은 5글자 이하여야 합니다.");


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
