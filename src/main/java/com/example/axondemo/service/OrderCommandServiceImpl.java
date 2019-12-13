package com.example.axondemo.service;

import com.example.axondemo.commands.create.OrderReceiveCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */
@Service
public class OrderCommandServiceImpl implements OrderCommandService {
    private final CommandGateway commandGateway;

    public OrderCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<OrderReceiveCommand> receiveOrder(Long id) {
        OrderReceiveCommand orderReceiveCommand = new OrderReceiveCommand(id);
       return commandGateway.send(orderReceiveCommand);
    }
}
