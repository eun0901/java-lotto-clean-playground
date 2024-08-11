package domain.enums;

public enum ErrorMessage {
    MUST_BE_6("로또는 무조건 6자리여야 합니다."),
    RANGE_OF_LOTTO_NUMBER("로또 번호는 1과 45 사이의 값이어야 합니다."),
    MUST_BE_NOT_DUPLICATE("로또 번호는 중복이 될 수 없다.");



    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    // 메시지를 반환하는 toString 메서드
    @Override
    public String toString() {
        return message;
    }
}
