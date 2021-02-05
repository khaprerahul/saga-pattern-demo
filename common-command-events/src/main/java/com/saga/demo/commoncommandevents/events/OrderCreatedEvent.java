package com.saga.demo.commoncommandevents.events;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
public class OrderCreatedEvent {

    public final String orderId;

    public final String itemType;

    public final BigDecimal price;

    public final String currency;

    public final String orderStatus;


}
