package lotto.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.constant.LotteryConstant.LOTTERY_MAX;
import static lotto.constant.LotteryConstant.LOTTERY_MIN;

public class WinNumbers {

    private Set<LotteryNumber> numbers;
    private int bonusNumber;

    public WinNumbers(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new RuntimeException("잘못된 로또 번호 목록입니다. : " + numbers);
        }
        this.numbers = numbers.stream().map(LotteryNumber::of).collect(Collectors.toSet());
    }

    public WinNumbers(Set<Integer> numbers, int bonusNumber) {
        if (numbers.size() != 6 || bonusNumber > LOTTERY_MAX || bonusNumber <  LOTTERY_MIN) {
            throw new RuntimeException("잘못된 로또 번호 목록입니다.");
        }
        this.numbers = numbers.stream().map(LotteryNumber::of).collect(Collectors.toSet());
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(Set<LotteryNumber> others) {
        Set<LotteryNumber> intersection = new HashSet<>(numbers);
        intersection.retainAll(others);
        return intersection.size();
    }

}
