package com.example.axondemo.commands.create;

import com.example.axondemo.commands.BaseCommand;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OrderActiveCommand extends BaseCommand<Long> {

    public OrderActiveCommand(Long id) {
        super(id);
    }
}
