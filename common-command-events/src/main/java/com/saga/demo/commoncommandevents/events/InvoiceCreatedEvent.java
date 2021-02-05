package com.saga.demo.commoncommandevents.events;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InvoiceCreatedEvent  {

    public final String paymentId;

    public final String orderId;

}
