package com.event.driven.command.api.model;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
@Data
@Builder
public class ProductRestModel {
    @TargetAggregateIdentifier
    private String Name;
    private BigDecimal price;
    private int quantity;

}
