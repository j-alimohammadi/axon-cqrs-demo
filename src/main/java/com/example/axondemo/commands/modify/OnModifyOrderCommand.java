package com.example.axondemo.commands.modify;

import com.example.axondemo.commands.BaseCommand;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnModifyOrderCommand extends BaseCommand<Long> {

    public OnModifyOrderCommand(Long id) {
        super(id);
    }
}
