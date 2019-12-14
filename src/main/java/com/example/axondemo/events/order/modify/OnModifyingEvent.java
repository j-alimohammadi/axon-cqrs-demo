package com.example.axondemo.events.order.modify;

import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnModifyingEvent extends AbstractBaseEvent<Long> {
    public OnModifyingEvent(Long id) {
        super(id);
    }
}
