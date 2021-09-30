package baseball.domain;

import baseball.exception.CustomException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @ParameterizedTest(name = "Number 생성 [{index}] : {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9}) // given
    void create(int numberOk) {
        // when
        Number number = new Number(numberOk);
        // then
        assertThat(number).isEqualTo(new Number(numberOk));
    }

    @ParameterizedTest(name = "Number 범위(1~9) 초과에 따른 생성 실패 [{index}] : {0}")
    @ValueSource(ints = {0, 10}) // given
    void create_fail(int numberFail) {
        // when, then
        assertThatThrownBy(() -> new Number(numberFail))
                .isInstanceOf(CustomException.class);
    }

}