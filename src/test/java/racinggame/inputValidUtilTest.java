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
import racinggame.model.Racing;
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
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputValidUtils.isConsecutiveComma(carNames);
        }).withMessage(ErrorType.ERROR_CONSECUTIVE_COMMA.getErrMsg());
    }

    @Test
    void 마지막_쉼표_공백() {
        String carNames = "이거,저거,조고, ";
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputValidUtils.isLastCommaBlank(carNames);
        }).withMessage(ErrorType.ERROR_LAST_COMMA_BLANK.getErrMsg());
    }

    @Test
    void 공백만_있는_이름() {
        String carNames = "  ,이거,   ,저거,   ,조고";
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputValidUtils.isNameBlank(carNames);
        }).withMessage(ErrorType.ERROR_NAME_BLANK.getErrMsg());
    }

    @Test
    void 이름_중복_확인() {
        String carNames = "이거,이거,저거,저거,조고,저거";
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputValidUtils.isDuplicateNames(carNames);
        }).withMessage(ErrorType.ERROR_DUPLICATE_NAME.getErrMsg());
    }

    @Test
    void 다섯글자_이상_검증() {
        String sixDigit = "다섯번째글자";

        assertThatIllegalArgumentException().isThrownBy(()->{
            new CarName(sixDigit);
        }).withMessage(ErrorType.ERROR_LIMIT_CAR_NAME.getErrMsg());

    }

    @Test
    void 자동차_이름_두대_이상() {
        String[] carNames = {"이꺼"};
        assertThatIllegalArgumentException().isThrownBy(()->{
            new Racing(carNames);
        }).withMessage(ErrorType.ERROR_MINIMUM_CAR.getErrMsg());
    }

    @Test
    void 숫자_입력_검증() {
        String runningTime = "14f";
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputValidUtils.isNumber(runningTime);
        }).withMessage(ErrorType.ERROR_ONLY_NUMBER.getErrMsg());


    }

    @Test
    void 큰_숫자_검증() {
        String bigNumber = "4011";
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputValidUtils.isBigNum(bigNumber);
        }).withMessage(ErrorType.ERROR_TOO_BIG_NUMBER.getErrMsg());
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
