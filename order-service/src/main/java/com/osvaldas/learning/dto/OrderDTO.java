package com.osvaldas.learning.dto;

import com.osvaldas.learning.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private List<OrderLineItems> orderLineItemsList;
}
