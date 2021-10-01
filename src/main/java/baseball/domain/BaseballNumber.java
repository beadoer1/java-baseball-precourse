package baseball.domain;

import java.util.Objects;

public class BaseballNumber {

    private final Index index;
    private final Number number;

    public BaseballNumber(int index, int number) {
        this.index = new Index(index);
        this.number = new Number(number);
    }

    public Check result(BaseballNumber anotherBaseballNumber) {
        if (this.index.equals(anotherBaseballNumber.index) && this.number.equals(anotherBaseballNumber.number)) {
            return Check.SAME_ALL;
        }

        if (this.number.equals(anotherBaseballNumber.number)) {
            return Check.SAME_NUMBER;
        }

        return Check.DIFFERENT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseballNumber)) return false;
        BaseballNumber that = (BaseballNumber) o;
        return Objects.equals(index, that.index) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, number);
    }
}
