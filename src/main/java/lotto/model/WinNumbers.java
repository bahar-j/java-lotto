package lotto.model;

import java.util.List;

import static lotto.constant.LotteryConstant.LOTTERY_MAX;
import static lotto.constant.LotteryConstant.LOTTERY_MIN;

public class WinNumbers {

    private final List<Integer> numbers;
    private int bonusNumber;

    protected WinNumbers(List<Integer> numbers) {
        if (numbers.size() != 6 || bonusNumber > LOTTERY_MAX || bonusNumber <  LOTTERY_MIN) {
            throw new RuntimeException("잘못된 로또 번호 목록입니다.");
        }
        this.numbers = numbers;
    }

    public WinNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != 6 || bonusNumber > LOTTERY_MAX || bonusNumber <  LOTTERY_MIN) {
            throw new RuntimeException("잘못된 로또 번호 목록입니다.");
        }
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }
}
