package baseball.domain;

import java.util.Objects;

public class ResultDto {
    private final int strike;
    private final int ball;

    public ResultDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultDto)) return false;
        ResultDto resultDto = (ResultDto) o;
        return strike == resultDto.strike && ball == resultDto.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
