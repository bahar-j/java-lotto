package lotto.model;

import lotto.util.NumberGenerator;

public class LotteryNumber {

    private final int number;

    public LotteryNumber(NumberGenerator numberGenerator) {
        this.number = numberGenerator.generate();
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
