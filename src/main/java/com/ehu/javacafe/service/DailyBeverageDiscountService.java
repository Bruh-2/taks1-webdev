package com.ehu.javacafe.service;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DailyBeverageDiscountService {
    public void applyDiscount(){
        System.out.println("Discount applied!");
    }
}
