package com.osvaldas.learning.controller;

import com.osvaldas.learning.model.Inventory;
import com.osvaldas.learning.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/inventory")
public class InventoryController {

    private final InventoryRepository repository;

    @GetMapping("{skuCode}")
    Boolean inInStock(@PathVariable String skuCode) {
        Inventory inventory = repository.findBySkuCode(skuCode)
                .orElseThrow(() -> new RuntimeException("Cannot find product by sku code: " + skuCode));
        return inventory.getStock() > 0;
    }
}
