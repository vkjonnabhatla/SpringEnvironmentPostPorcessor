package com.example.http.headers.SpringEnvironmentPostPorcessor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component
public class NetPriceCalculator implements PriceCalculator, ApplicationContextAware {

    public NetPriceCalculator(){
        System.out.println("NetPriceCalculator default constructor");
    }

    @Override
    public double calculate(double singlePrice, int quantity) {
        double result = Math.round(singlePrice * quantity);
        return result;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("NetPriceCalculator setApplicationContext method");
    }
}
