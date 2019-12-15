package com.example.axondemo.entity.handler;

import com.example.axondemo.events.AbstractBaseEvent;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public interface OrderQueryEntityHandler {

    void handleOrderEvent(AbstractBaseEvent<Long> abstractBaseEvent);
}
