package com.saga.demo.commoncommandevents.events;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderUpdatedEvent {

    public final String orderId;

    public final String orderStatus;

}
