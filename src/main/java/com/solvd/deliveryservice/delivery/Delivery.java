package com.solvd.deliveryservice.delivery;

import com.solvd.deliveryservice.order.Order;

public class Delivery {
    final public static int LOCAL_LEAD_TIME_DAYS = 2;
    final public static int NATIONAL_LEAD_TIME_DAYS = 3;
    final public static int EXPRESS_FACTOR = -1;

    public static int getLeadTime(Order order){
        int expressOrder = order.isExpress()? 1:0;
        if(order.getAddress().checkIfLocalAddress(order.getAddress().getState())) {
            return LOCAL_LEAD_TIME_DAYS + expressOrder*EXPRESS_FACTOR;
        } else {
            return NATIONAL_LEAD_TIME_DAYS + expressOrder*EXPRESS_FACTOR;
        }

    }
}


