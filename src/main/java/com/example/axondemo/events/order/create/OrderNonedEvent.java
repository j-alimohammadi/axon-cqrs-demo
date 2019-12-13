package com.example.axondemo.events.order.create;

import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OrderNonedEvent extends AbstractBaseEvent<Long> {

    public OrderNonedEvent(Long id) {
        super(id);
    }
}
