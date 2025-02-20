package lotto.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.constant.LotteryConstant.*;

public class WinNumbers {

    private static final double BONUS_COUNT = 0.5;

    private final Set<LotteryNumber> numbers;
    private LotteryNumber bonusNumber;

    public WinNumbers(Set<Integer> numbers) {
        validate(numbers, null);
        this.numbers = numbers.stream().map(LotteryNumber::of).collect(Collectors.toSet());
    }

    public WinNumbers(Set<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers.stream().map(LotteryNumber::of).collect(Collectors.toSet());
        this.bonusNumber = LotteryNumber.of(bonusNumber);
    }

    private void validate(Set<Integer> numbers, Integer bonusNumber) {
        if (numbers.size() != NUMBER_PER_TICKET ||
                (bonusNumber != null && bonusNumber > LOTTERY_MAX) ||
                (bonusNumber != null && bonusNumber <  LOTTERY_MIN)
        ) {
            throw new IllegalArgumentException("잘못된 로또 번호 목록입니다. : " + numbers);
        }
    }

    public double matchCount(Set<LotteryNumber> others) {
        Set<LotteryNumber> intersection = new HashSet<>(numbers);
        intersection.retainAll(others);

        double count = intersection.size();
        if (bonusNumber != null && others.contains(bonusNumber)) {
            return count + BONUS_COUNT;
        }
        return count;
    }

}
