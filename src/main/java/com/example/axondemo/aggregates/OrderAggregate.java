package com.example.axondemo.aggregates;

import com.example.axondemo.commands.cancel.CanceleOrderCommand;
import com.example.axondemo.commands.cancel.OnCanceleOrderCommand;
import com.example.axondemo.commands.create.ActiveOrderCommand;
import com.example.axondemo.commands.create.OnBoardOrderCommand;
import com.example.axondemo.commands.create.ReceiveOrderCommand;
import com.example.axondemo.commands.modify.ModifyOrderCommand;
import com.example.axondemo.commands.modify.OnModifyOrderCommand;
import com.example.axondemo.events.order.cancel.OnCanceledEvent;
import com.example.axondemo.events.order.cancel.OnCancellingEvent;
import com.example.axondemo.events.order.create.OnActivatedEvent;
import com.example.axondemo.events.order.create.OnBoardEvent;
import com.example.axondemo.events.order.create.OrderNonedEvent;
import com.example.axondemo.events.order.modify.OnModifiedEvent;
import com.example.axondemo.events.order.modify.OnModifyingEvent;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

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

    private Integer quantity;

    private OrderStatus orderStatus;

    private double price;

    public OrderAggregate() {
    }


    @CommandHandler
    public OrderAggregate(ReceiveOrderCommand receiveOrderCommand) {
        AggregateLifecycle.apply(new OrderNonedEvent(receiveOrderCommand.id,
                receiveOrderCommand.quantity
                , receiveOrderCommand.price, OrderStatus.NONE));
    }

    @EventSourcingHandler
    public void on(OrderNonedEvent orderNonedEvent) {
        this.id = orderNonedEvent.id;
        this.omsId = orderNonedEvent.omsId;
        this.orderStatus = orderNonedEvent.orderStatus;
        this.price = orderNonedEvent.price;
        this.quantity = orderNonedEvent.quantity;

        log.info("Init Order id=[{}], state=[{}], price=[{}], quantity=[{}]  ", id, orderStatus.toString(), price, quantity);
    }

    @CommandHandler
    public void on(OnBoardOrderCommand onBoardOrderCommand) {
        if (this.orderStatus != OrderStatus.NONE) {
            throw new RuntimeException("Order Should be on none status first");
        }
        AggregateLifecycle.apply(new OnBoardEvent(onBoardOrderCommand.id, OrderStatus.ON_BOARD));


    }

    @EventSourcingHandler
    public void on(OnBoardEvent onBoardEvent) {
        log.info("Changing order id=[{}] from status [{}] to status=[{}]", this.id, this.orderStatus, onBoardEvent.orderStatus);
        this.orderStatus = onBoardEvent.orderStatus;
    }


    @CommandHandler
    public void on(ActiveOrderCommand activeOrderCommand) {
        if (this.orderStatus != OrderStatus.ON_BOARD) {
            throw new RuntimeException("Order Should be on on_board status");
        }
        AggregateLifecycle.apply(new OnActivatedEvent(activeOrderCommand.id, OrderStatus.ACTIVATE));

    }

    @EventSourcingHandler
    public void on(OnActivatedEvent onActivatedEvent) {
        log.info("Changing order id=[{}] from status [{}] to status=[{}]", this.id, this.orderStatus, onActivatedEvent.orderStatus);
        this.orderStatus = onActivatedEvent.orderStatus;

    }


    @CommandHandler
    public void on(OnModifyOrderCommand onModifyOrderCommand) {
        if (this.orderStatus != OrderStatus.ACTIVATE) {
            throw new RuntimeException("Order Should be on activate status");
        }

        AggregateLifecycle.apply(new OnModifyingEvent(onModifyOrderCommand.id, OrderStatus.ON_MODIFY));
    }

    @EventSourcingHandler
    public void on(OnModifyingEvent onModifyingEvent) {
        log.info("Changing order id=[{}] from status [{}] to status=[{}]", this.id, this.orderStatus, onModifyingEvent.orderStatus);
        this.orderStatus = onModifyingEvent.orderStatus;
    }

    @CommandHandler
    public void on(ModifyOrderCommand modifyOrderCommand) {
        if (this.orderStatus != OrderStatus.ON_MODIFY) {
            throw new RuntimeException("Order Should be on modified status");
        }

        AggregateLifecycle.apply(new OnModifiedEvent(modifyOrderCommand.id, OrderStatus.MODIFIED));
    }

    @EventSourcingHandler
    public void on(OnModifiedEvent onModifiedEvent) {
        log.info("Changing order id=[{}] from status [{}] to status=[{}]", this.id, this.orderStatus, onModifiedEvent.orderStatus);
        this.orderStatus = onModifiedEvent.orderStatus;
    }


    @CommandHandler
    public void on(OnCanceleOrderCommand onCanceleOrderCommand) {
        if (this.orderStatus == OrderStatus.NONE) {
            throw new RuntimeException("Order Should be created first");
        }

        if (this.orderStatus == OrderStatus.CANCELED) {
            throw new RuntimeException("Order is canceled before");
        }

        AggregateLifecycle.apply(new OnCancellingEvent(onCanceleOrderCommand.id, OrderStatus.ON_CANCEL));
    }


    @EventSourcingHandler
    public void on(OnCancellingEvent onCancellingEvent) {
        log.info("Changing order id=[{}] from status [{}] to status=[{}]", this.id, this.orderStatus, onCancellingEvent.orderStatus);
        this.orderStatus = onCancellingEvent.orderStatus;
    }

    @CommandHandler
    public void on(CanceleOrderCommand canceleOrderCommand) {
        if (this.orderStatus == OrderStatus.NONE) {
            throw new RuntimeException("Order Should be created first");
        }

        if (this.orderStatus == OrderStatus.CANCELED) {
            throw new RuntimeException("Order is canceled before");
        }

        AggregateLifecycle.apply(new OnCanceledEvent(canceleOrderCommand.id, OrderStatus.CANCELED));
    }


    @EventSourcingHandler
    public void on(OnCanceledEvent onCanceledEvent) {
        log.info("Changing order id=[{}] from status [{}] to status=[{}]", this.id, this.orderStatus, onCanceledEvent.orderStatus);
        this.orderStatus = onCanceledEvent.orderStatus;
    }

}
