package com.example.http.headers.SpringEnvironmentPostPorcessor;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class PriceCalculationAutoConfig {

    public PriceCalculationAutoConfig(){
        System.out.println("PriceCalculationAutoConfig default constructor");
    }

    @Bean
    @ConditionalOnProperty(name = "com.example.environmentpostprocessor.calculation.mode", havingValue = "NET")
    @ConditionalOnMissingBean
    public PriceCalculator getNetPriceCalculator(){
        System.out.println("PriceCalculationAutoConfig getNetPriceCalculator method");
        return new NetPriceCalculator();
    }

    @Bean
    @ConditionalOnProperty(name = "com.example.environmentpostprocessor.calculation.mode", havingValue = "GROSS")
    @ConditionalOnMissingBean
    public PriceCalculator getGrossPriceCalculator(){
        System.out.println("PriceCalculationAutoConfig getGrossPriceCalculator method");
        return new GrassPriceCalculator();
    }
}
