package com.ehu.javacafe.service;

import com.ehu.javacafe.entity.Beverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Scope("prototype")
public class BeverageSelectorRandom implements BeverageSelector {
    private final int amountOfBeverages;
    private final CoffeeService beverageService;
    private BeverageHistoryService beverageHistoryService;

    @Autowired
    public BeverageSelectorRandom(CoffeeService beverageService, BeverageHistoryService beverageHistoryService) {
        this.beverageService = beverageService;
        this.amountOfBeverages = new Random().nextInt(3) + 1;
        this.beverageHistoryService = beverageHistoryService;
    }

    @Override
    public List<Beverage> selectBeverage() {
        long beverageCount = beverageService.getBeverageCount();
        List<Beverage> order = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amountOfBeverages; i++) {
            long randomId = 1 + (long) (random.nextDouble() * beverageCount);
            Beverage beverageById = beverageService.getBeverageById(randomId);
            order.add(beverageById);
        }

        beverageHistoryService.saveSelection(order);

        return order;
    }
}
