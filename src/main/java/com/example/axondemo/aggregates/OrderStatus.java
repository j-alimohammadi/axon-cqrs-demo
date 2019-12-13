package com.example.axondemo.aggregates;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public enum OrderStatus {
    NONE(0, "بدون وضعیت"),
    MODIFY(1, "ویرایش"),
    ERROR(2, "خطا"),
    CANCEL(3, "حذف دستور"),
    DELETE(4, "ابطال دستور"),
    DONE(5, "انجام شد");


    public final long value;

    public final String friendlyDescription;

    OrderStatus(int value, String friendlyDescription) {
        this.value = value;
        this.friendlyDescription = friendlyDescription;
    }


}
