package com.example.axondemo.events.order.cancel;

import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnCanceledEvent extends AbstractBaseEvent<Long> {

    public OnCanceledEvent(Long id) {
        super(id);
    }
}
