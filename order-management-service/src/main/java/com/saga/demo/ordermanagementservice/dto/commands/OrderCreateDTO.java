package com.saga.demo.ordermanagementservice.dto.commands;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderCreateDTO {

    private String itemType;

    private BigDecimal price;

    private String currency;

}
