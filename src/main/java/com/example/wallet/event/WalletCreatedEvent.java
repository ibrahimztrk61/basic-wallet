package com.example.wallet.event;


public class WalletCreatedEvent {

    private final String id;

    public WalletCreatedEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
