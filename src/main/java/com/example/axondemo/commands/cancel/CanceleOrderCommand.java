package com.example.axondemo.commands.cancel;

import com.example.axondemo.commands.BaseCommand;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class CanceleOrderCommand extends BaseCommand<Long> {
    public CanceleOrderCommand(Long id) {
        super(id);
    }
}
