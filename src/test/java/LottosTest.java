//import domain.Lotto;
//import domain.LottoNumber;
//import domain.Lottos;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThatCode;
//
//public class LottosTest {
//
//    @Test
//    @DisplayName("입력한 로또의 개수만큼 로또가 생성되어야 한다.")
//    void makeLottosTest () {
//        final int countOfLotto = 3;
//        final List<Integer> numbers = List.of(new Integer[]{1, 2, 3, 4, 5, 6});
//        final List<LottoNumber> lottoNumbers = numbers.stream()
//                .map(LottoNumber::new)
//                .toList();
//
//        final Lotto lotto = new Lotto(lottoNumbers);
//
//        final List<Lotto> lottos = new ArrayList<>();
//
//        for (int i = 0; i < countOfLotto; i ++) {
//            lottos.add(lotto);
//        }
//
//        assertThatCode(() -> new Lottos(lottos)).doesNotThrowAnyException();
//    }
//}
