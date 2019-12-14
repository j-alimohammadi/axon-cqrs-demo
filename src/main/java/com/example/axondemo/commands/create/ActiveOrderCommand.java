package com.example.axondemo.commands.create;

import com.example.axondemo.commands.BaseCommand;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class ActiveOrderCommand extends BaseCommand<Long> {

    public ActiveOrderCommand(Long id) {
        super(id);
    }
}
