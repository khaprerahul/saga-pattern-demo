package com.saga.demo.commoncommandevents.commands;

import lombok.AllArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@AllArgsConstructor
public class CreateInvoiceCommand{

    @TargetAggregateIdentifier
    public final String paymentId;

    public final String orderId;

}
