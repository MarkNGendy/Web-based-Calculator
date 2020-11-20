package com.calculator.model;

import com.calculator.controllers.OneTermOperation;
import com.calculator.controllers.TwoTermsOperation;

public class Calculator implements ICalculator{

    @Override
    public String oneTermCalculation(OneTermOperation oneTermOperation) {
        double firstTerm = oneTermOperation.firstTerm;
        double result;
        switch (oneTermOperation.operator) {
            case SQUARE:
                result = Math.pow(firstTerm, 2);
                break;
            case ROOT:
                result = Math.sqrt(firstTerm);
                break;
            case INVERSE:
                if (Double.compare(firstTerm, 0) != 0) {
                    result = 1 / firstTerm;
                    break;
                } else {
                    return "Cannot divide by zero";
                }
            case PERCENT:
                result = firstTerm / 100;
                break;
            case ABSOLUTE:
                result = Math.abs(firstTerm);
                break;
            default:
                return ("Error");
        }
        return String.valueOf(result);
    }

    @Override
    public String twoTermCalculation(TwoTermsOperation twoTermsOperation) {
        double firstTerm = twoTermsOperation.firstOp;
        double secondTerm = twoTermsOperation.secondOp;
        double result = 0;
        switch (twoTermsOperation.operator) {
            case ADD:
                result = firstTerm + secondTerm;
                break;
            case SUBTRACT:
                result = firstTerm - secondTerm;
                break;
            case MULTIPLY:
                result = firstTerm * secondTerm;
                break;
            case DIVIDE:
                if (Double.compare(secondTerm, 0) == 0){
                    return "Cannot divide by zero";
                }
                result = firstTerm / secondTerm;
                break;
            default:
                return ("Error");
        }
        return String.valueOf(result);
    }

}
