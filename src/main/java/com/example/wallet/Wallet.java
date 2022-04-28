package com.example.wallet;

import com.example.wallet.command.CreateWalletCommand;
import com.example.wallet.event.WalletCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
public class Wallet {

    @AggregateIdentifier
    private String id;

    private BigDecimal balance;

    @CommandHandler
    public Wallet(CreateWalletCommand command) {
        WalletCreatedEvent event = new WalletCreatedEvent(command.getId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(WalletCreatedEvent event) {
        this.id = event.getId();
        this.balance = BigDecimal.ZERO;
    }
}
