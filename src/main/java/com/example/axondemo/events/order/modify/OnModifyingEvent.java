package com.example.axondemo.events.order.modify;

import com.example.axondemo.aggregates.OrderStatus;
import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnModifyingEvent extends AbstractBaseEvent<Long> {

    public final OrderStatus orderStatus;

    public OnModifyingEvent(Long id, OrderStatus orderStatus) {
        super(id);
        this.orderStatus = orderStatus;
    }
}
