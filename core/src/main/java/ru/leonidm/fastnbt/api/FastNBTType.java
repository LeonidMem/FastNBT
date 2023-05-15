package ru.leonidm.fastnbt.api;

public enum FastNBTType {

    BYTE(1),
    SHORT(2),
    INT(3),
    LONG(4),
    FLOAT(5),
    DOUBLE(6),
    BYTE_ARRAY(7),
    STRING(8),
    LIST(9),
    COMPOUND(10),
    INT_ARRAY(11);

    private final int id;

    FastNBTType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
