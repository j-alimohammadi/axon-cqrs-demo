package com.example.axondemo.commands.create;

import com.example.axondemo.commands.BaseCommand;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OrderOnBoardCommand extends BaseCommand<Long> {

    public OrderOnBoardCommand(Long id) {
        super(id);
    }
}
