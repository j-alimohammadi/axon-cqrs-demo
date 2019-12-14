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
    public OrderAggregate(ReceiveOrderCommand receiveOrderCommand) {
        AggregateLifecycle.apply(new OrderNonedEvent(receiveOrderCommand.id));
    }

    @EventSourcingHandler
    public void on(OrderNonedEvent orderNonedEvent) {
        this.id = orderNonedEvent.id;
        this.omsId = UUID.randomUUID().toString();
        this.orderStatus = OrderStatus.NONE;

        log.info("Init Order id=[{}] state=[{}]", id, orderStatus.toString());
    }

    @CommandHandler
    public void on(OnBoardOrderCommand onBoardOrderCommand) {
        if (this.orderStatus != OrderStatus.NONE) {
            throw new RuntimeException("Order Should be on none status first");
        }
        AggregateLifecycle.apply(new OnBoardEvent(onBoardOrderCommand.id));


    }

    @EventSourcingHandler
    public void on(OnBoardEvent onBoardEvent) {
        log.info("Changing order id=[{}] from status [{}] to status=[{}]", this.id, this.orderStatus, OrderStatus.ON_BOARD);
        this.orderStatus = OrderStatus.ON_BOARD;
    }


    @CommandHandler
    public void on(ActiveOrderCommand activeOrderCommand) {
        if (this.orderStatus != OrderStatus.ON_BOARD) {
            throw new RuntimeException("Order Should be on on_board status");
        }
        AggregateLifecycle.apply(new OnActivatedEvent(activeOrderCommand.id));

    }

    @EventSourcingHandler
    public void on(OnActivatedEvent onActivatedEvent) {
        log.info("Changing order id=[{}] from status [{}] to status=[{}]", this.id, this.orderStatus, OrderStatus.ACTIVATE);
        this.orderStatus = OrderStatus.ACTIVATE;

    }


    @CommandHandler
    public void on(OnModifyOrderCommand onModifyOrderCommand) {
        if (this.orderStatus != OrderStatus.ACTIVATE) {
            throw new RuntimeException("Order Should be on activate status");
        }

        AggregateLifecycle.apply(new OnModifyingEvent(onModifyOrderCommand.id));
    }

    @EventSourcingHandler
    public void on(OnModifyingEvent onModifyingEvent) {
        log.info("Changing order id=[{}] from status [{}] to status=[{}]", this.id, this.orderStatus, OrderStatus.ON_MODIFY);
        this.orderStatus = OrderStatus.ON_MODIFY;
    }

    @CommandHandler
    public void on(ModifyOrderCommand modifyOrderCommand) {
        if (this.orderStatus != OrderStatus.ON_MODIFY) {
            throw new RuntimeException("Order Should be on modified status");
        }

        AggregateLifecycle.apply(new OnModifiedEvent(modifyOrderCommand.id));
    }

    @EventSourcingHandler
    public void on(OnModifiedEvent onModifiedEvent) {
        log.info("Changing order id=[{}] from status [{}] to status=[{}]", this.id, this.orderStatus, OrderStatus.MODIFIED);
        this.orderStatus = OrderStatus.MODIFIED;
    }


    @CommandHandler
    public void on(OnCanceleOrderCommand onCanceleOrderCommand) {
        if (this.orderStatus == OrderStatus.NONE) {
            throw new RuntimeException("Order Should be created first");
        }

        if (this.orderStatus == OrderStatus.CANCELED) {
            throw new RuntimeException("Order is canceled before");
        }

        AggregateLifecycle.apply(new OnCancellingEvent(onCanceleOrderCommand.id));
    }


    @EventSourcingHandler
    public void on(OnCancellingEvent onCancellingEvent) {
        log.info("Changing order id=[{}] from status [{}] to status=[{}]", this.id, this.orderStatus, OrderStatus.ON_CANCEL);
        this.orderStatus = OrderStatus.ON_CANCEL;
    }

    @CommandHandler
    public void on(CanceleOrderCommand canceleOrderCommand) {
        if (this.orderStatus == OrderStatus.NONE) {
            throw new RuntimeException("Order Should be created first");
        }

        if (this.orderStatus == OrderStatus.CANCELED) {
            throw new RuntimeException("Order is canceled before");
        }

        AggregateLifecycle.apply(new OnCanceledEvent(canceleOrderCommand.id));
    }


    @EventSourcingHandler
    public void on(OnCanceledEvent onCanceledEvent) {
        log.info("Changing order id=[{}] from status [{}] to status=[{}]", this.id, this.orderStatus, OrderStatus.CANCELED);
        this.orderStatus = OrderStatus.CANCELED;
    }

}
