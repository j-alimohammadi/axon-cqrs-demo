package com.example.axondemo.commands.create;

import com.example.axondemo.commands.BaseCommand;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */
@Getter
@Setter
public class OrderReceiveCommand extends BaseCommand<Long> {

    public OrderReceiveCommand(Long id) {
        super(id);
    }
}
