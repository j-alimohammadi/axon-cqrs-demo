package com.example.axondemo.commands.create;

import com.example.axondemo.commands.BaseCommand;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public class OnBoardOrderCommand extends BaseCommand<Long> {

    public OnBoardOrderCommand(Long id) {
        super(id);
    }
}
