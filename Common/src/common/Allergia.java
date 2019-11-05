package common;

import java.util.HashMap;
import java.util.Map;

public enum Allergia {
    Gluten(1),
    Tej(2),
    Mogyoro(3),
    Hisztamin(4),
    Laktoz(5),
    Kazein(6),
    Nincs(7);

    public int getValue() {
        return value;
    }

    int value;

    private static Map map = new HashMap<>();

    Allergia(int p){
        value = p;
    }

    static {
        for (Allergia allergia : Allergia.values()) {
            map.put(allergia.value, allergia);
        }
    }

    public static Allergia valueOf(int allergia) {
        return (Allergia) map.get(allergia);
    }
}
