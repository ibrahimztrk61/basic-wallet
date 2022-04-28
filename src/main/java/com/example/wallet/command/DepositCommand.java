package com.example.wallet.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

public class DepositCommand {

    @TargetAggregateIdentifier
    private final String id;

    private final BigDecimal amount;

    public DepositCommand(String id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
