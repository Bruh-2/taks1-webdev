package com.ehu.javacafe.service;

import com.ehu.javacafe.entity.Beverage;
import com.ehu.javacafe.repository.BeverageCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DailyBeverageDiscountService {

    private static final Logger logger =
            LoggerFactory.getLogger(DailyBeverageDiscountService.class);

    private static final double DISCOUNT_PERCENT = 0.10; // 10%

    private final BeverageCrudRepository beverageCrudRepository;

    public DailyBeverageDiscountService(BeverageCrudRepository beverageCrudRepository) {
        this.beverageCrudRepository = beverageCrudRepository;
    }

    public void applyDiscount() {
        Iterable<Beverage> beverages = beverageCrudRepository.findAll();

        for (Beverage beverage : beverages) {
            double oldPrice = beverage.getPrice();
            double newPrice = oldPrice * (1 - DISCOUNT_PERCENT);

            beverage.setPrice(newPrice);
            beverageCrudRepository.save(beverage);

            logger.info("Discount applied to {}: {} -> {}",
                    beverage.getName(), oldPrice, newPrice);
        }
    }
}
