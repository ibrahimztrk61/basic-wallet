package com.example;

import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
import org.axonframework.eventsourcing.SnapshotTriggerDefinition;
import org.axonframework.eventsourcing.Snapshotter;
import org.axonframework.springboot.autoconfig.AxonServerAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration(exclude = AxonServerAutoConfiguration.class)
public class BasicWalletApplication {

    private static final int SNAPSHOT_THRESHOLD = 3;

    public static void main(String[] args) {
        SpringApplication.run(BasicWalletApplication.class, args);
    }

    @Bean
    public SnapshotTriggerDefinition walletSnapshotDefinition(Snapshotter snapshotter) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, SNAPSHOT_THRESHOLD);
    }

}

