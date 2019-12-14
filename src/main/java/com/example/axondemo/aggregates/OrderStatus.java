package com.example.axondemo.aggregates;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

public enum OrderStatus {
    NONE(0, "بدون وضعیت"),
    ON_BOARD(1, "سفارش دریافت شد"),
    ACTIVATE(1, "فعال شده"),
    ON_MODIFY(1, "در حال ویرایش"),
    MODIFIED(1, "ویرایش"),
    ERROR(2, "خطا"),
    CANCELED(3, "حذف دستور"),
    ON_CANCEL(3, "حذف دستور"),
    DELETED(4, "ابطال دستور"),
    DONE(5, "انجام شد");


    public final long value;

    public final String friendlyDescription;

    OrderStatus(int value, String friendlyDescription) {
        this.value = value;
        this.friendlyDescription = friendlyDescription;
    }


}
