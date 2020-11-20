package com.calculator.controllers;

import com.calculator.model.Operator;

public class TwoTermsOperation {
    public double firstOp;
    public double secondOp;
    public Operator operator;


    public TwoTermsOperation(double firstOp, double secondOp, Operator operator) {
        this.firstOp = firstOp;
        this.secondOp = secondOp;
        this.operator = operator;
    }
}
