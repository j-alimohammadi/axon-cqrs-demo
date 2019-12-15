package com.example.axondemo.events.order.modify;

import com.example.axondemo.aggregates.OrderStatus;
import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnModifiedEvent extends AbstractBaseEvent<Long> {
    public final OrderStatus orderStatus;

    public OnModifiedEvent(Long id, OrderStatus orderStatus) {
        super(id);
        this.orderStatus = orderStatus;
    }
}
