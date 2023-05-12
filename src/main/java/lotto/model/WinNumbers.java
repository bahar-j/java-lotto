package lotto.model;

import java.util.List;

public class WinNumbers {

    private List<Integer> numbers;

    public WinNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new RuntimeException("잘못된 로또 번호 목록입니다. : " + numbers);
        }
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
