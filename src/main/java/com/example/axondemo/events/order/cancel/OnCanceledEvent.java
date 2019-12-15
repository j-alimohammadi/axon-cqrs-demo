package com.example.axondemo.events.order.cancel;

import com.example.axondemo.aggregates.OrderStatus;
import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnCanceledEvent extends AbstractBaseEvent<Long> {
    public final OrderStatus orderStatus;

    public OnCanceledEvent(Long id, OrderStatus orderStatus) {
        super(id);
        this.orderStatus = orderStatus;
    }
}
