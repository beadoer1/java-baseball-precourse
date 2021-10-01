package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballNumbers {
    private final List<BaseballNumber> baseballNumbers = new ArrayList<>();

    public BaseballNumbers(List<Integer> numbers) {
        for (int i = 1; i <= 3; i++) {
            baseballNumbers.add(new BaseballNumber(i, numbers.get(i - 1)));
        }
    }

    public ResultDto result(BaseballNumbers anotherBaseballNumbers) {
        int strike = 0;
        int ball = 0;
        for (BaseballNumber baseballNumber : baseballNumbers) {
            for (BaseballNumber anotherBaseballNumber : anotherBaseballNumbers.baseballNumbers) {
                if (baseballNumber.result(anotherBaseballNumber).equals(Check.SAME_ALL)) {
                    strike++;
                } else if (baseballNumber.result(anotherBaseballNumber).equals(Check.SAME_NUMBER)) {
                    ball++;
                }
            }
        }
        return new ResultDto(strike, ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseballNumbers)) return false;
        BaseballNumbers that = (BaseballNumbers) o;
        return Objects.equals(baseballNumbers, that.baseballNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumbers);
    }
}
