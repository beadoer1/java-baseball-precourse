package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BaseballNumbersTest {

    @Test
    @DisplayName("BaseballNumbers 생성")
    void create() {
        // given
        int number1 = 1;
        int number2 = 2;
        int number3 = 3;
        // when
        BaseballNumbers baseballNumbers = makeBaseball(number1, number2, number3);
        // then
        assertThat(baseballNumbers).isEqualTo(makeBaseball(1, 2, 3));
    }

    @ParameterizedTest(name = "BaseballNumbers answer 비교 결과 반환 [{index}] {0},{1},{2} : strike {3}, ball {4}")
    @CsvSource({"1, 2, 3, 3, 0", "1, 2, 4, 2, 0", "1, 4, 5, 1, 0", "2, 3, 1, 0, 3", "2, 3, 4, 0, 2", "3, 4, 5, 0, 1", "4, 5, 6, 0, 0"})
    void result(int number1, int number2, int number3, int strike, int ball) {
        // given
        BaseballNumbers answerBaseballNumbers = makeBaseball(1, 2, 3);
        BaseballNumbers baseballNumbers = makeBaseball(number1, number2, number3);
        // when
        ResultDto resultDto = answerBaseballNumbers.result(baseballNumbers);
        // then
        assertThat(resultDto).isEqualTo(new ResultDto(strike, ball));
    }

    BaseballNumbers makeBaseball(int number1, int number2, int number3) {
        List<Integer> numbers = new ArrayList<>();
        int[] numbersArr = new int[]{number1, number2, number3};
        for (int number : numbersArr) {
            numbers.add(number);
        }
        return new BaseballNumbers(numbers);
    }
}