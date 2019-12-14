package com.example.axondemo.endpoint;

import com.example.axondemo.commands.create.OnBoardOrderCommand;
import com.example.axondemo.commands.create.ReceiveOrderCommand;
import com.example.axondemo.service.OrderCommandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

@RestController
@RequestMapping("/order")
public class OrderEndPoint {
    private OrderCommandService orderCommandService;

    public OrderEndPoint(OrderCommandService orderCommandService) {
        this.orderCommandService = orderCommandService;
    }

    @PostMapping("/receive")
    public CompletableFuture<ReceiveOrderCommand> receiveOrder(Long orderId) {
        return orderCommandService.receiveOrder(orderId);
    }

    @PutMapping("/onBoardOrder")
    public CompletableFuture<OnBoardOrderCommand> onBoardOrder(Long orderId) {
        return orderCommandService.onBoardOrder(orderId);
    }


    @PutMapping("/activeOrder")
    public CompletableFuture<OnBoardOrderCommand> activeOrder(Long orderId) {
        return orderCommandService.activeOrder(orderId);
    }

      @PutMapping("/activeOrder")
    public CompletableFuture<OnBoardOrderCommand> activeOrder(Long orderId) {
        return orderCommandService.activeOrder(orderId);
    }

    


}
