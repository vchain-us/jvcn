package us.vchain.jvcn;

public enum Status {
    TRUSTED(0),
    UNTRUSTED(1),
    UNKNOWN(2),
    UNSUPPORTED(3);

    private final int value;

    Status(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Status from(final int value) {
        switch (value) {
            case 0:
                return TRUSTED;
            case 1:
                return UNTRUSTED;
            case 2:
                return UNKNOWN;
            case 3:
                return UNSUPPORTED;
            default:
                throw new IllegalArgumentException("Invalid status value: " + value);
        }
    }
}
