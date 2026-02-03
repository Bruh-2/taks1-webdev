package com.ehu.javacafe.service;

import jakarta.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DiscountRunner {

    private final ApplicationContext context;

    public DiscountRunner(ApplicationContext context) {
        this.context = context;
    }

    @PostConstruct
    public void runAfterStartup() throws InterruptedException {
        runAfterDelay(5);
    }

    public void runAfterDelay(int seconds) throws InterruptedException { //try running sleep method without try-catch method(done)
        Thread.sleep(seconds * 1000L);

        DailyBeverageDiscountService discountService =
                context.getBean(DailyBeverageDiscountService.class);

        discountService.applyDiscount();
    }
}
