package common;

public enum Allergia {
    Gluten(1),
    Tej(2),
    Mogyoro(3),
    Hisztamin(4),
    Laktoz(5),
    Kazein(6);

    public int getValue() {
        return value;
    }

    int value;

    Allergia(int p){
        value = p;
    }
}
