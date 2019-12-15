package com.example.axondemo.commands.create;

import com.example.axondemo.commands.BaseCommand;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */
@Getter
@Setter
public class ReceiveOrderCommand extends BaseCommand<Long> {

    public final Integer quantity;
    public final Double price;

    public ReceiveOrderCommand(Long id, Integer quantity, Double price) {
        super(id);
        this.quantity = quantity;
        this.price = price;
    }
}
