package com.example.axondemo.events.order.create;

import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnActivatedEvent extends AbstractBaseEvent<Long> {
    public OnActivatedEvent(Long id) {
        super(id);
    }
}
