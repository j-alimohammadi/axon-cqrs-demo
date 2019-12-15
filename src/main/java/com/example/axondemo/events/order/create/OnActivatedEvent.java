package com.example.axondemo.events.order.create;

import com.example.axondemo.aggregates.OrderStatus;
import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnActivatedEvent extends AbstractBaseEvent<Long> {
    public final OrderStatus orderStatus;

    public OnActivatedEvent(Long id, OrderStatus orderStatus) {
        super(id);
        this.orderStatus = orderStatus;
    }
}
