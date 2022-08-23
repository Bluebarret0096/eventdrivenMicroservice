package com.event.driven.command.api.controller;
import com.event.driven.command.api.commands.CreateProductCommand;
import com.event.driven.command.api.model.ProductRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/products")
public class ProductCommandController {

    private CommandGateway commandGateway;

    public ProductCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addProduct(@RequestBody ProductRestModel ProductRestModel) {

        CreateProductCommand createProductCommand =
                CreateProductCommand.builder()
                        .productId(UUID.randomUUID().toString())
                        .name(ProductRestModel.getName())
                        .price(ProductRestModel.getPrice())
                        .quantity(ProductRestModel.getQuantity())
                        .build();

        return commandGateway.sendAndWait(createProductCommand);
    }
}