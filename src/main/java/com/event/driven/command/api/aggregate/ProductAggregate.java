package com.event.driven.command.api.aggregate;

import com.event.driven.command.api.commands.CreateProductCommand;
import com.event.driven.command.api.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private int quantity;
    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){

        ProductCreatedEvent productCreatedEvent =
                new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand,productCreatedEvent);
        AggregateLifecycle.apply(productCreatedEvent);
;
    }

    public ProductAggregate() {
    }
    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        this.quantity = productCreatedEvent.getQuantity();
        this.price = productCreatedEvent.getPrice();
        this.productId = productCreatedEvent.getProductId();
        this.name = productCreatedEvent.getName();



    }
}
