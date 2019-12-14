package com.example.axondemo.commands.modify;

import com.example.axondemo.commands.BaseCommand;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class ModifyOrderCommand extends BaseCommand<Long> {

    public ModifyOrderCommand(Long id) {
        super(id);
    }
}
