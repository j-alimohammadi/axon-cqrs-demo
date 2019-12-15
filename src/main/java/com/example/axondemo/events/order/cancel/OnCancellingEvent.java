package com.example.axondemo.events.order.cancel;

import com.example.axondemo.aggregates.OrderStatus;
import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnCancellingEvent extends AbstractBaseEvent<Long> {
    public final OrderStatus orderStatus;

    public OnCancellingEvent(Long id, OrderStatus orderStatus) {
        super(id);
        this.orderStatus = orderStatus;
    }
}
