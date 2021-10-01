package baseball.domain;

import baseball.exception.CustomException;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(int number) {
        validateOverRange(number);
        this.number = number;
    }

    private void validateOverRange(int number) {
        if (number < 1 || number > 9) {
            throw new CustomException("허용 숫자의 범위(1~9)를 벗어났습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
