package com.ehu.javacafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DiscountRunner {

    @Autowired
    private ApplicationContext context;

    public void runAfterDelay(int seconds) {
        try {
            Thread.sleep(seconds * 1000L); // wait N seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        DailyBeverageDiscountService discountService = context.getBean(DailyBeverageDiscountService.class);
        discountService.applyDiscount();
    }
}
