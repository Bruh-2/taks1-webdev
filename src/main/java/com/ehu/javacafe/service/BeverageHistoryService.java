package com.ehu.javacafe.service;

import com.ehu.javacafe.entity.Beverage;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class BeverageHistoryService {

    private static final String HISTORY_FILE = "beverage_history.txt";

    public void saveSelection(List<Beverage> beverages) {
        try (FileWriter writer = new FileWriter(HISTORY_FILE, true)) {
            for (Beverage b : beverages) {
                writer.write(b.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("BeverageHistoryService bean created!");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("BeverageHistoryService bean is being destroyed...");
    }
}