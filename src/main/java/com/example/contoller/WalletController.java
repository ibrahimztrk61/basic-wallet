package com.example.contoller;

import com.example.wallet.command.CreateWalletCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    private final CommandGateway commandGateway;

    public WalletController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/create")
    public void createWallet (String id) {
        CreateWalletCommand command = new CreateWalletCommand(id);
        commandGateway.send(command);
    }
}
