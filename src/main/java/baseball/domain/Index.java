package baseball.domain;

import baseball.exception.CustomException;

import java.util.Objects;

public class Index {

    private final int index;

    public Index(int index) {
        validateOverRange(index);
        this.index = index;
    }

    private void validateOverRange(int index) {
        if (index < 1 || index > 3) {
            throw new CustomException("허용 index 를 벗어났습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Index)) return false;
        Index index1 = (Index) o;
        return index == index1.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
