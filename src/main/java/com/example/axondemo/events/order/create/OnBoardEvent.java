package com.example.axondemo.events.order.create;

import com.example.axondemo.aggregates.OrderStatus;
import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnBoardEvent extends AbstractBaseEvent<Long> {
    public final OrderStatus orderStatus;

    public OnBoardEvent(Long id, OrderStatus orderStatus) {
        super(id);
        this.orderStatus = orderStatus;
    }
}
