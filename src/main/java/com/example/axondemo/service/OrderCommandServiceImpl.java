package com.example.axondemo.service;

import com.example.axondemo.commands.create.ReceiveOrderCommand;
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
    public CompletableFuture<ReceiveOrderCommand> receiveOrder(Long id) {
        ReceiveOrderCommand receiveOrderCommand = new ReceiveOrderCommand(id);
       return commandGateway.send(receiveOrderCommand);
    }
}
