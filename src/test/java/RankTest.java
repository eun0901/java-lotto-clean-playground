import domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("당첨된 번호의 개수에 맞는 랭크를 반환한다.")
    void correctRank () {
        assertThat(Rank.findRank(5, true)).isEqualTo(Rank.RANK_SECOND);
    }
}
