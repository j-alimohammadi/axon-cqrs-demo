package com.example.axondemo.events.order.create;

import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnBoardEvent extends AbstractBaseEvent<Long> {
    public OnBoardEvent(Long id) {
        super(id);
    }
}
