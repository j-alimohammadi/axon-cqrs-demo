package com.example.axondemo.events.order.create;

import com.example.axondemo.aggregates.OrderStatus;
import com.example.axondemo.events.AbstractBaseEvent;

import java.util.UUID;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OrderNonedEvent extends AbstractBaseEvent<Long> {
    public final String omsId;

    public final Integer quantity;

    public final double price;

    public final OrderStatus orderStatus;

    public OrderNonedEvent(Long id, Integer quantity, Double price, OrderStatus orderStatus) {
        super(id);
        this.quantity = quantity;
        this.price = price;
        this.omsId = UUID.randomUUID().toString();
        this.orderStatus = orderStatus;
    }

}
