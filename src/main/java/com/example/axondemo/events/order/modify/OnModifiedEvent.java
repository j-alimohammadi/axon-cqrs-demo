package com.example.axondemo.events.order.modify;

import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnModifiedEvent extends AbstractBaseEvent<Long> {
    public OnModifiedEvent(Long id) {
        super(id);
    }
}
