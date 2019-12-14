package com.example.axondemo.events.order.create;

import com.example.axondemo.events.AbstractBaseEvent;

import java.util.UUID;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OrderNonedEvent extends AbstractBaseEvent<Long> {
    public final String omsId;

    public OrderNonedEvent(Long id) {
        super(id);
        omsId = UUID.randomUUID().toString();
    }

}
