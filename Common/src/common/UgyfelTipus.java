package common;

public enum UgyfelTipus {
    Ugyfel(1),
    CegesUgyfel(2),
    CsaladosUgyfel(3);

    int value;
    UgyfelTipus(int tipus) {
        value = tipus;
    }

    public int getValue() {
        return value;
    }
}
