package us.vchain.jvcn;

public enum Level {
    UNKNOWN(0),
    EMAIL_VERIFIED(1),
    SOCIAL_VERIFIED(2),
    ID_VERIFIED(3),
    LOCATION_VERIFIED(4),
    VCHAIN(99),
    DISABLED(-1);

    private final int value;

    Level(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Level from(final int value) {
        switch (value) {
            case 0:
                return UNKNOWN;
            case 1:
                return EMAIL_VERIFIED;
            case 2:
                return SOCIAL_VERIFIED;
            case 3:
                return ID_VERIFIED;
            case 4:
                return LOCATION_VERIFIED;
            case 99:
                return VCHAIN;
            case -1:
                return DISABLED;
            default:
                throw new IllegalArgumentException("Invalid level value: " + value);
        }
    }
}
