package com.saga.demo.ordermanagementservice.service.commands;


import com.saga.demo.ordermanagementservice.dto.commands.OrderCreateDTO;

import java.util.concurrent.CompletableFuture;

public interface OrderCommandService {

    public CompletableFuture<String> createOrder(OrderCreateDTO orderCreateDTO);

}
