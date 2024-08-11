package domain.enums;

public enum Constant {
    SIZE_OF_LOTTO(6);


    private final Integer constant;

    Constant(Integer constant) {
        this.constant = constant;
    }

    public Integer toInteger() {
        return constant;
    }
}
