import domain.Lotto;
import domain.LottoNumber;
import domain.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottoTest {
    @Test
    @DisplayName("하나의 로또는 6개의 로또 번호를 가진다.")
    void validateLotto () {
        final List<Integer> numbers = List.of(new Integer[]{1, 2, 3, 4, 5, 6});
        final List<LottoNumber> lottoNumbers = numbers.stream()
                        .map(LottoNumber::new)
                        .toList();

        assertThatCode(() -> new Lotto(lottoNumbers)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("하나의 로또가 6개의 로또 번호를 가지고 있지 않으면 오류를 반환한다.")
    void invalidateLotto () {
        final List<Integer> numbers = List.of(new Integer[]{1, 2, 3, 4});
        final List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MUST_BE_6.toString());
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다.")
    void NotDuplicateLottoNumber () {
        final List<Integer> numbers = List.of(new Integer[]{1, 2, 3, 4, 5, 6});
        final List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();

        assertThatCode(() -> new Lotto(lottoNumbers)).doesNotThrowAnyException();

    }

    @Test
    @DisplayName("로또 번호가 중복되었다면 오류를 반환한다.")
    void DuplicateLottoNumber () {
        final List<Integer> numbers = List.of(new Integer[]{1, 2, 3, 4, 4, 5});
        final List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MUST_BE_NOT_DUPLICATE.toString());
    }
}
