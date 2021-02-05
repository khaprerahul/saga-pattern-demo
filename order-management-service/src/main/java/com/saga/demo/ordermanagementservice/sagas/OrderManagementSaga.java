package com.saga.demo.ordermanagementservice.sagas;


import com.saga.demo.commoncommandevents.commands.CreateInvoiceCommand;
import com.saga.demo.commoncommandevents.commands.CreateShippingCommand;
import com.saga.demo.commoncommandevents.commands.UpdateOrderStatusCommand;
import com.saga.demo.commoncommandevents.events.InvoiceCreatedEvent;
import com.saga.demo.commoncommandevents.events.OrderCreatedEvent;
import com.saga.demo.commoncommandevents.events.OrderShippedEvent;
import com.saga.demo.commoncommandevents.events.OrderUpdatedEvent;
import com.saga.demo.ordermanagementservice.aggregates.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import javax.inject.Inject;
import java.util.UUID;

@Saga
@Slf4j
public class OrderManagementSaga {

    @Inject
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent orderCreatedEvent) {
        String paymentId = UUID.randomUUID().toString();
        log.info("Saga invoked for payment id {} ",paymentId);

        //associate Saga
        SagaLifecycle.associateWith("paymentId", paymentId);

        log.info("order id {}", orderCreatedEvent.orderId);

        //send the commands
        commandGateway.send(new CreateInvoiceCommand(paymentId, orderCreatedEvent.orderId));
    }

    @SagaEventHandler(associationProperty = "paymentId")
    public void handle(InvoiceCreatedEvent invoiceCreatedEvent) {
        String shippingId = UUID.randomUUID().toString();

        log.info("Saga continued");

        //associate Saga with shipping
        SagaLifecycle.associateWith("shipping", shippingId);

        //send the create shipping command
        commandGateway.send(new CreateShippingCommand(shippingId, invoiceCreatedEvent.orderId, invoiceCreatedEvent.paymentId));
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderShippedEvent orderShippedEvent) {
        commandGateway.send(new UpdateOrderStatusCommand(orderShippedEvent.orderId, String.valueOf(OrderStatus.SHIPPED)));
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderUpdatedEvent orderUpdatedEvent) {
        SagaLifecycle.end();
    }
}
