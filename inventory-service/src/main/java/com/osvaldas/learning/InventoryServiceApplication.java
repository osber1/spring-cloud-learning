package com.osvaldas.learning;

import com.osvaldas.learning.model.Inventory;
import com.osvaldas.learning.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class InventoryServiceApplication implements CommandLineRunner {
    private final InventoryRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Inventory inventory = new Inventory(1L, "IPHONE_12_RED", 10);
        Inventory inventory1 = new Inventory(2L, "IPHONE_12_GREY", 0);
        repository.save(inventory);
        repository.save(inventory1);
    }
}
