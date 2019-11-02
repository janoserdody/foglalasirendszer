package common;

import java.util.HashMap;
import java.util.Map;

public enum FoglalasTipus {
    Foglalas(1),
    AsztalFoglalas(2),
    TeremFoglalas(3);

    int value;
    private static Map map = new HashMap<>();

    FoglalasTipus(int value) {
        this.value = value;
    }

    static {
        for (FoglalasTipus foglalasTipus : FoglalasTipus.values()) {
            map.put(foglalasTipus.value, foglalasTipus);
        }
    }

    public static FoglalasTipus valueOf(int foglalasTipus) {
        return (FoglalasTipus) map.get(foglalasTipus);
    }

    public int getValue() {
        return value;
    }
}
