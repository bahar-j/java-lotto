package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @DisplayName("범위 밖의 숫자로 생성할 경우 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] number: {0}")
    @ValueSource(ints = {0, 46})
    void create_InvalidRangeNumber(int invalidRangeNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(invalidRangeNumber))
                .withMessage(LottoNumber.INVALID_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("정상적인 생성")
    @ParameterizedTest(name = "[{index}] number: {0}")
    @ValueSource(ints = {1, 30, 45})
    void create(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @DisplayName("정렬 테스트")
    @Test
    void sort() {
        //given
        LottoNumber smallLottoNumber = new LottoNumber(1);
        LottoNumber bigLottoNumber = new LottoNumber(45);
        List<LottoNumber> lottoNumbers = asList(bigLottoNumber, smallLottoNumber);

        //when
        Collections.sort(lottoNumbers);

        //then
        assertThat(lottoNumbers).isEqualTo(asList(smallLottoNumber, bigLottoNumber));
    }

}
