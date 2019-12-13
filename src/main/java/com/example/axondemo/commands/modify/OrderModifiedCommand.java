package com.example.axondemo.commands.modify;

import com.example.axondemo.commands.BaseCommand;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OrderModifiedCommand extends BaseCommand<Long> {

    public OrderModifiedCommand(Long id) {
        super(id);
    }
}
