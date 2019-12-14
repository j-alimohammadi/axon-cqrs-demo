package com.example.axondemo.service;

import com.example.axondemo.commands.create.ReceiveOrderCommand;

import java.util.concurrent.CompletableFuture;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public interface OrderCommandService {
    CompletableFuture<ReceiveOrderCommand> receiveOrder(Long id);
}
