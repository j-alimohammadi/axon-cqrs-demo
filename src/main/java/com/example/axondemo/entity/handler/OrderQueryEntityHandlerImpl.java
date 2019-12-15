package com.example.axondemo.entity.handler;

import com.example.axondemo.aggregates.OrderAggregate;
import com.example.axondemo.entity.OrderQueryEntity;
import com.example.axondemo.entity.OrderQueryRepository;
import com.example.axondemo.events.AbstractBaseEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */
@Service
public class OrderQueryEntityHandlerImpl implements OrderQueryEntityHandler {

    @Resource
    private OrderQueryRepository orderQueryRepository;

    @Resource(name = "orderAggregateEventSourcingRepository")
    private EventSourcingRepository<OrderAggregate> orderAggregateEventSourcingRepository;

    @EventSourcingHandler
    @Override
    public void handleOrderEvent(AbstractBaseEvent<Long> event) {
        OrderAggregate orderAggregate = findAggregate(event.id);

        OrderQueryEntity orderQueryEntity = OrderQueryEntity.builder()
                .orderId(orderAggregate.getId())
                .orderStatus(orderAggregate.getOrderStatus().toString())
                .omsId(orderAggregate.getOmsId())
                .price(orderAggregate.getPrice())
                .createdTimeStamp(new Date())
                .build();

        orderQueryRepository.save(orderQueryEntity);
    }

    private OrderAggregate findAggregate(Long aggregateId) {
        return orderAggregateEventSourcingRepository.load(String.valueOf(aggregateId)).getWrappedAggregate().getAggregateRoot();
    }

}
