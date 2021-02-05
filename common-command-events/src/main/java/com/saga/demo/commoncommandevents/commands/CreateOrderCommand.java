package com.saga.demo.commoncommandevents.commands;

import lombok.AllArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
@AllArgsConstructor
public class CreateOrderCommand {

    @TargetAggregateIdentifier
    public final String orderId;

    public final String itemType;

    public final BigDecimal price;

    public final String currency;

    public final String orderStatus;

}
