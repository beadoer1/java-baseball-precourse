package baseball.domain;

import baseball.exception.CustomException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class IndexTest {

    @ParameterizedTest(name = "Index 생성 [{index}] : {0}")
    @ValueSource(ints = {1, 2, 3}) // given
    void create(int numberOk) {
        // when
        Index index = new Index(numberOk);
        // then
        assertThat(index).isEqualTo(new Index(numberOk));
    }

    @ParameterizedTest(name = "index 범위(1~3) 초과에 따른 생성 실패 [{index}] : {0}")
    @ValueSource(ints = {0, 4}) // given
    void create_fail(int numberFail) {
        // when, then
        assertThatThrownBy(() -> new Index(numberFail))
                .isInstanceOf(CustomException.class);
    }

}