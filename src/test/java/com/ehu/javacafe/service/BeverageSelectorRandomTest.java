package com.ehu.javacafe.service;

import com.ehu.javacafe.entity.Beverage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeverageSelectorRandomTest {

    @Test
    void testSelectBeverage() {

        CoffeeService mockService = Mockito.mock(CoffeeService.class);
        Mockito.when(mockService.getBeverageCount()).thenReturn(3L);
        Mockito.when(mockService.getBeverageById(Mockito.anyLong()))
                .thenReturn(new Beverage(1L, "Coffee", 2.5, "Tasty"));


        BeverageHistoryService mockHistory = Mockito.mock(BeverageHistoryService.class);
        Mockito.doNothing().when(mockHistory).saveSelection(Mockito.anyList());


        BeverageSelectorRandom selector = new BeverageSelectorRandom(mockService, mockHistory);
        List<Beverage> drinks = selector.selectBeverage();
        assertTrue(drinks.size() >= 1 && drinks.size() <= 3);
    }
}
