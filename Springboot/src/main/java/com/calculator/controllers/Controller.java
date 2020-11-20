package com.calculator.controllers;

import com.calculator.CalculatorApplication;
import com.calculator.model.Calculator;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
public class Controller {

    @PostMapping("/")
    public String calculate(@RequestBody TwoTermsOperation twoTermsOperation) {
        Calculator calulator = new Calculator();
        return (calulator.twoTermCalculation(twoTermsOperation));
    }

    @CrossOrigin
    @PostMapping("/oneop")
    public String calculate(@RequestBody OneTermOperation oneTermOperation) {
        Calculator calulator = new Calculator();
        return (calulator.oneTermCalculation(oneTermOperation));
    }
}
