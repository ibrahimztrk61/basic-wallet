package com.example.contoller;

import com.example.wallet.command.CreateWalletCommand;
import com.example.wallet.command.DepositCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class WalletController {

    private final CommandGateway commandGateway;

    public WalletController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/{id}")
    public void createWallet(@PathVariable("id") String id) {
        CreateWalletCommand command = new CreateWalletCommand(id);
        commandGateway.sendAndWait(command);
    }

    @PutMapping("/{id}/deposit")
    public void deposit(@PathVariable("id") String id, @RequestParam("amount") BigDecimal amount) {
        DepositCommand command = new DepositCommand(id, amount);
        commandGateway.sendAndWait(command);
    }
}
