package com.example.axondemo.commands.modify;

import com.example.axondemo.commands.BaseCommand;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OrderOnModifyCommand extends BaseCommand<Long> {

    public OrderOnModifyCommand(Long id) {
        super(id);
    }
}
