package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers); // 오름차순 정렬
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
