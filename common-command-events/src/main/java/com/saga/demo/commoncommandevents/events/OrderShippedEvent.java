package com.saga.demo.commoncommandevents.events;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderShippedEvent {

    public final String shippingId;

    public final String orderId;

    public final String paymentId;

}
