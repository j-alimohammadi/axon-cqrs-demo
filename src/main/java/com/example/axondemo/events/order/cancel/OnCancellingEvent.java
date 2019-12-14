package com.example.axondemo.events.order.cancel;

import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnCancellingEvent extends AbstractBaseEvent<Long> {
    public OnCancellingEvent(Long id) {
        super(id);
    }
}
