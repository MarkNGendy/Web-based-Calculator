package com.calculator.model;

public enum Operator {
    ADD ("ADD"),
    SUBTRACT ("SUBTRACT"),
    MULTIPLY ("MULTIPLY"),
    DIVIDE ("DIVIDE"),
    PERCENT("PERCENT"),
    SQUARE("SQUARE"),
    ROOT("ROOT"),
    INVERSE("INVERSE"),
    ABSOLUTE("ABSOLUTE");
    public final String name;
    Operator(String name) {
        this.name = name;
    }
}
