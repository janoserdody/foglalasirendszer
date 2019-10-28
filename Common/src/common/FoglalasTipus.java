package common;

public enum FoglalasTipus {
    Foglalas(1),
    AsztalFoglalas(2),
    TeremFoglalas(3);

    int value;

    FoglalasTipus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
