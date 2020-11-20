package com.calculator.model;

import com.calculator.controllers.OneTermOperation;
import com.calculator.controllers.TwoTermsOperation;

public interface ICalculator {
    public String twoTermCalculation(TwoTermsOperation twoTermsOperation);
    public String oneTermCalculation(OneTermOperation oneTermOperation);
}
