package domain;

import domain.enums.Constant;
import domain.enums.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> lotto;

    public Lotto (final List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);

        this.lotto = List.copyOf(lottoNumbers);
    }

    private void validate (final List<LottoNumber> lottoNumbers) {
        isCorrectSize(lottoNumbers);
        isDuplicate(lottoNumbers);
    }

    private void isCorrectSize (final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Constant.SIZE_OF_LOTTO.toInteger()) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_6.toString());
        }
    }

    private void isDuplicate(final List<LottoNumber> lottoNumbers) {
        List<LottoNumber> duplicates = lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumbers.stream()
                        .filter(existingNumber -> existingNumber.equals(lottoNumber))
                        .count() > 1)
                .distinct()
                .toList();

        if (!duplicates.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NOT_DUPLICATE.toString());
        }
    }


}
