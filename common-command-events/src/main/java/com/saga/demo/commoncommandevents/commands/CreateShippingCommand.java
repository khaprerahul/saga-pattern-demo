package com.saga.demo.commoncommandevents.commands;

import lombok.AllArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@AllArgsConstructor
public class CreateShippingCommand {

    @TargetAggregateIdentifier
    public final String shippingId;

    public final String orderId;

    public final String paymentId;

}
