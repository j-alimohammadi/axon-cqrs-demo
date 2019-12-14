package com.example.axondemo.service;

import com.example.axondemo.commands.cancel.CanceleOrderCommand;
import com.example.axondemo.commands.cancel.OnCanceleOrderCommand;
import com.example.axondemo.commands.create.OnBoardOrderCommand;
import com.example.axondemo.commands.create.ReceiveOrderCommand;
import com.example.axondemo.commands.modify.ModifyOrderCommand;
import com.example.axondemo.commands.modify.OnModifyOrderCommand;

import java.util.concurrent.CompletableFuture;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public interface OrderCommandService {
    CompletableFuture<ReceiveOrderCommand> receiveOrder(Long id);

    CompletableFuture<OnBoardOrderCommand> onBoardOrder(Long id);

    CompletableFuture<OnBoardOrderCommand> activeOrder(Long id);

    CompletableFuture<OnModifyOrderCommand> onModifyOrder(Long id);

    CompletableFuture<ModifyOrderCommand> modifyOrder(Long id);

    CompletableFuture<OnCanceleOrderCommand> OnCancelOrder(Long id);

    CompletableFuture<CanceleOrderCommand> cancelOrder(Long id);
}
