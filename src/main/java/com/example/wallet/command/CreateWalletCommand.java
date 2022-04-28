package com.example.wallet.command;

public class CreateWalletCommand {

    private final String id;

    public CreateWalletCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
