package com.ehu.javacafe.service;

import com.ehu.javacafe.entity.Beverage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.ehu.javacafe")
public class MainAnnotation {

    public static void main(String[] args) {
        // Bootstraps Spring Boot application context
        ApplicationContext ctx = SpringApplication.run(MainAnnotation.class, args);

        // Get your services from the context
        CoffeeService coffeeService = ctx.getBean(CoffeeService.class);
        coffeeService.getAllBeverages();

        BeverageSelectorRandom selector = ctx.getBean(BeverageSelectorRandom.class);
        List<Beverage> beverages = selector.selectBeverage();

        // No need to explicitly close the context; Spring Boot manages it
    }
}
