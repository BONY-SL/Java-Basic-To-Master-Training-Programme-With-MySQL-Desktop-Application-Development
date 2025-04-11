package com.springboot.academy.pointofsale.util.queryinterface;

import java.util.Date;

public interface OrderDetailsInterface {

    // customer
    String getCustomerName();
    String getCustomerAddress();
    String getContactNumber();

    // order
    Date getDate();
    Double getOrderTotalPrice();

}
