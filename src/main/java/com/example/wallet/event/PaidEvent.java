package com.example.wallet.event;

import java.math.BigDecimal;

public class PaidEvent {

    private final BigDecimal amount;

    public PaidEvent(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPayAmount() {
        return amount;
    }
}
