package com.example.axondemo.commands.cancel;

import com.example.axondemo.commands.BaseCommand;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OrderOnCanceledCommand extends BaseCommand<Long> {
    public OrderOnCanceledCommand(Long id) {
        super(id);
    }
}
