package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constant.LotteryConstant.*;

public class AutoLotteryNumberGenerator implements LotteryNumberGenerator {

    private static final List<LotteryNumber> numbers = IntStream.rangeClosed(LOTTERY_MIN, LOTTERY_MAX)
            .boxed().map(LotteryNumber::of).collect(Collectors.toList());

    @Override
    public Set<LotteryNumber> generate() {
        List<LotteryNumber> newNumbers = initializeRandomNumberList();
        Set<LotteryNumber> result = new HashSet<>(newNumbers.subList(0, NUMBER_PER_TICKET));
        validate(result);
        return result;
    }

    private List<LotteryNumber> initializeRandomNumberList() {
        List<LotteryNumber> newNumbers = new ArrayList<>(numbers);
        Collections.shuffle(newNumbers);
        return newNumbers;
    }

    private void validate(Set<LotteryNumber> numbers) {
        if (numbers.size() != NUMBER_PER_TICKET || numbers.stream().distinct().count() != NUMBER_PER_TICKET) {
            throw new IllegalArgumentException("잘못된 로또 번호 목록입니다. : " + numbers);
        }
    }

}
