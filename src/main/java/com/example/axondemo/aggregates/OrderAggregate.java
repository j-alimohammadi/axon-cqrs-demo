package com.example.axondemo.aggregates;

import com.example.axondemo.commands.create.OrderReceiveCommand;
import com.example.axondemo.events.order.create.OrderNonedEvent;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

@Getter
@Setter
@Aggregate
@Slf4j
public class OrderAggregate {

    @AggregateIdentifier
    private Long id;

    private String omsId;

    private OrderStatus orderStatus;

    public OrderAggregate() {
    }


    @CommandHandler
    public OrderAggregate(OrderReceiveCommand orderReceiveCommand) {
        AggregateLifecycle.apply(new OrderNonedEvent(orderReceiveCommand.id));
    }

    @EventSourcingHandler
    public void on(OrderNonedEvent orderNonedEvent) {
        this.id = orderNonedEvent.id;
        this.omsId = UUID.randomUUID().toString();
        this.orderStatus = OrderStatus.NONE;

        log.info("Order id=[{}] state=[{}]", id, orderStatus.toString());
    }

    


}
