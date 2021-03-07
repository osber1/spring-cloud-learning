package com.osvaldas.learning.controller;

import com.osvaldas.learning.client.InventoryClient;
import com.osvaldas.learning.dto.OrderDTO;
import com.osvaldas.learning.model.Order;
import com.osvaldas.learning.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.function.Supplier;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;
    private final StreamBridge streamBridge;

    @PostMapping
    public String placeOrder(@RequestBody OrderDTO orderDto) {
        Resilience4JCircuitBreaker circuitBreaker = circuitBreakerFactory.create("inventory");
        Supplier<Boolean> booleanSupplier = () -> orderDto.getOrderLineItemsList()
                .stream()
                .allMatch(lineItem -> inventoryClient.checkStock(lineItem.getSkuCode()));
        boolean productsInStock = circuitBreaker.run(booleanSupplier, throwable -> handleErrorCase());

        if (productsInStock) {
            Order order = new Order();
            order.setOrderLineItems(orderDto.getOrderLineItemsList());
            order.setOrderNumber(UUID.randomUUID().toString());

            orderRepository.save(order);

            log.info("Sending Order Details to Notification Service");
            streamBridge.send("notificationEventSupplier-out-0", order.getId());
            return "Order Place Successfully";
        } else {
            return "Order Failed - One of the Product in your Order is out of stock";
        }
    }

    @GetMapping
    public String hello() {
        return "hello";
    }

    private Boolean handleErrorCase() {
        return false;
    }
}
