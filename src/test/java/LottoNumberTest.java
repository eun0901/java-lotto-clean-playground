import domain.LottoNumber;
import domain.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @Test
    @DisplayName("로또는 1~45 사이의 값을 가진다.")
    void validateLottoNumberTest () {
        final int number = 45;

        assertThatCode(() -> new LottoNumber(number)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또가 1~45 사이의 값을 가지지 않으면 오류가 발생한다.")
    void invalidateLottoNumberTest() {
        final int number = 46;

        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.RANGE_OF_LOTTO_NUMBER.toString());
    }

}
