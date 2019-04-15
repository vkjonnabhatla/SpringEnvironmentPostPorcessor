package com.example.http.headers.SpringEnvironmentPostPorcessor;

public interface PriceCalculator {
    double calculate(double singlePrice, int quantity);
}
