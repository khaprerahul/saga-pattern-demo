package com.saga.demo.commoncommandevents.commands;

import lombok.AllArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@AllArgsConstructor
public class UpdateOrderStatusCommand {

    @TargetAggregateIdentifier
    public final String orderId;

    public final String orderStatus;

}
