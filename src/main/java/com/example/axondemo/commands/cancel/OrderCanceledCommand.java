package com.example.axondemo.commands.cancel;

import com.example.axondemo.commands.BaseCommand;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OrderCanceledCommand extends BaseCommand<Long> {
    public OrderCanceledCommand(Long id) {
        super(id);
    }
}
