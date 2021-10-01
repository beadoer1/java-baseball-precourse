package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class BaseballNumberTest {

    @Test
    @DisplayName("BaseballNumber 생성")
    void create() {
        // given
        int index = 1;
        int number = 7;
        // when
        BaseballNumber baseballNumber = new BaseballNumber(index, number);
        // then
        assertThat(baseballNumber).isEqualTo(new BaseballNumber(1, 7));
    }

    @ParameterizedTest(name = "값 비교 : 자리 숫자 일치 여부 [{index}] {0}, {1} - {2}")
    @CsvSource({"1, 7, SAME_ALL", "2, 7, SAME_NUMBER", "2, 8, DIFFERENT"})
    void result_SAME_ALL(int index, int number, Check check) {
        // given
        BaseballNumber answerNumber = new BaseballNumber(1, 7);
        BaseballNumber baseballNumber = new BaseballNumber(index, number);
        // when
        Check result = baseballNumber.result(answerNumber);
        // then
        assertThat(result).isEqualTo(check);
    }
}