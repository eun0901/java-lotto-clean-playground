package domain;

import javax.naming.BinaryRefAddr;
import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    UNRANK(0, 0,
            (matchCount, isBonus) -> matchCount < 3),
    RANK_FIFTH(3, 5000,
            (matchCount, isBonus) -> matchCount == 3),
    RANK_FOURTH(4, 50000,
            (matchCount, isBonus) -> matchCount == 4),
    RANK_THIRD(5, 1500000,
            (matchCount, isBonus) -> matchCount == 5 && !isBonus),
    RANK_SECOND(5, 30000000,
            (matchCount, isBonus) -> matchCount == 5 && isBonus),
    RANK_FIRST(6, 2000000000,
                            (matchCount, isBonus) -> matchCount == 6);

    private final Integer matchCount;
    private final Integer prize;
    private final BiPredicate<Integer, Boolean> condition;

    Rank (int matchCount, int prize, BiPredicate<Integer, Boolean> condition) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.condition = condition;
    };

    public Integer getPrize() {
        return prize;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    private boolean test(Integer matchCount, boolean bonusMatch) {
        return condition.test(matchCount, bonusMatch);
    }

    public static Rank findRank (Integer matchCount, boolean bonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.test(matchCount, bonusMatch))
                .findAny()
                .orElse(UNRANK);
    }
}
