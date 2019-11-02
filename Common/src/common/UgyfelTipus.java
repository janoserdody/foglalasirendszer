package common;

import java.util.HashMap;
import java.util.Map;

public enum UgyfelTipus {
    Ugyfel(1),
    CegesUgyfel(2),
    CsaladosUgyfel(3);

    int value;
    private static Map map = new HashMap<>();

    UgyfelTipus(int tipus) {
        value = tipus;
    }

    static {
        for (UgyfelTipus ugyfelTipus : UgyfelTipus.values()) {
            map.put(ugyfelTipus.value, ugyfelTipus);
        }
    }

    public static UgyfelTipus valueOf(int ugyfelTipus) {
        return (UgyfelTipus) map.get(ugyfelTipus);
    }

    public int getValue() {
        return value;
    }
}
