package com.example.axondemo.config;

import com.example.axondemo.aggregates.OrderAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    

    @Bean
    EventSourcingRepository<OrderAggregate> OrderAggregateEventSourcingRepository(EventStore eventStore) {
        EventSourcingRepository<OrderAggregate> repository = EventSourcingRepository
                .builder(OrderAggregate.class)
                .eventStore(eventStore).build();
        return repository;
    }
}
