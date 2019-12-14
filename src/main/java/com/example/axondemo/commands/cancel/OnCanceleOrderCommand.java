package com.example.axondemo.commands.cancel;

import com.example.axondemo.commands.BaseCommand;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnCanceleOrderCommand extends BaseCommand<Long> {
    public OnCanceleOrderCommand(Long id) {
        super(id);
    }
}
