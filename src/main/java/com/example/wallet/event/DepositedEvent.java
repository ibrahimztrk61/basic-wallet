package com.example.wallet.event;

import java.math.BigDecimal;

public class DepositedEvent {

    private final BigDecimal amount;

    public DepositedEvent(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
