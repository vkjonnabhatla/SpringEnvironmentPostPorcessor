package com.example.http.headers.SpringEnvironmentPostPorcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component
public class GrassPriceCalculator implements PriceCalculator, ApplicationContextAware {

    @Value("${com.example.environmentpostprocessor.gross.calculation.tax.rate}")
    double taxRate;

    public GrassPriceCalculator(){
        System.out.println("GrassPriceCalculator default constructor");
    }

    @Override
    public double calculate(double singlePrice, int quantity) {
        double netPrice = singlePrice * quantity;
        double result = Math.round(netPrice * (1 + taxRate));
        return result;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      System.out.println("GrassPriceCalculator setApplicationContext method");
    }
}
