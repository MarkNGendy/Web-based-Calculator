package com.calculator.controllers;

import com.calculator.model.Operator;

public class OneTermOperation {
    public double firstTerm;
    public Operator operator;

    public OneTermOperation(double firstTerm, Operator operator) {
        this.firstTerm = firstTerm;
        this.operator = operator;
    }
}
