package com.example.axondemo.service.command;

import com.example.axondemo.commands.cancel.CanceleOrderCommand;
import com.example.axondemo.commands.cancel.OnCanceleOrderCommand;
import com.example.axondemo.commands.create.ActiveOrderCommand;
import com.example.axondemo.commands.create.OnBoardOrderCommand;
import com.example.axondemo.commands.create.ReceiveOrderCommand;
import com.example.axondemo.commands.modify.ModifyOrderCommand;
import com.example.axondemo.commands.modify.OnModifyOrderCommand;
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
    public CompletableFuture<ReceiveOrderCommand> receiveOrder(Long id, Double price, Integer quantity) {
        ReceiveOrderCommand receiveOrderCommand = new ReceiveOrderCommand(id, quantity, price);
        return commandGateway.send(receiveOrderCommand);
    }

    @Override
    public CompletableFuture<OnBoardOrderCommand> onBoardOrder(Long id) {
        OnBoardOrderCommand onBoardOrderCommand = new OnBoardOrderCommand(id);
        return commandGateway.send(onBoardOrderCommand);
    }

    @Override
    public CompletableFuture<ActiveOrderCommand> activeOrder(Long id) {
        ActiveOrderCommand activeOrderCommand = new ActiveOrderCommand(id);
        return commandGateway.send(activeOrderCommand);
    }

    @Override
    public CompletableFuture<OnModifyOrderCommand> onModifyOrder(Long id) {
        OnModifyOrderCommand onModifyOrderCommand = new OnModifyOrderCommand(id);
        return commandGateway.send(onModifyOrderCommand);
    }

    @Override
    public CompletableFuture<ModifyOrderCommand> modifyOrder(Long id) {
        ModifyOrderCommand modifyOrderCommand = new ModifyOrderCommand(id);
        return commandGateway.send(modifyOrderCommand);
    }

    @Override
    public CompletableFuture<OnCanceleOrderCommand> OnCancelOrder(Long id) {
        OnCanceleOrderCommand onCanceleOrderCommand = new OnCanceleOrderCommand(id);
        return commandGateway.send(onCanceleOrderCommand);
    }

    @Override
    public CompletableFuture<CanceleOrderCommand> cancelOrder(Long id) {
        CanceleOrderCommand onCanceleOrderCommand = new CanceleOrderCommand(id);
        return commandGateway.send(onCanceleOrderCommand);
    }


}
