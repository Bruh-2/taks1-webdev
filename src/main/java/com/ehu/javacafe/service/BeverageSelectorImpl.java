package com.ehu.javacafe.service;

import com.ehu.javacafe.entity.Beverage;
import com.ehu.javacafe.repository.BeverageRepository;

import java.util.List;

public class BeverageSelectorImpl implements BeverageSelector {
    private final BeverageRepository beverageRepository;

    public BeverageSelectorImpl(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    @Override
    public List<Beverage> selectBeverage() {
        return beverageRepository.getAllBeverages();
    }
}
