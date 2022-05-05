package com.example;

import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
import org.axonframework.eventsourcing.SnapshotTriggerDefinition;
import org.axonframework.eventsourcing.Snapshotter;
import org.axonframework.springboot.autoconfig.AxonServerAutoConfiguration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @EnableRabbit
    @Configuration
    public class RabbitConfig {

        @Bean
        public FanoutExchange exchange(@Value("${axon.amqp.exchange}") String name) {
            FanoutExchange exchange = new FanoutExchange(name);
            return exchange;
        }

        @Bean
        public Queue queue() {
            Queue queue = new Queue("wallet.events.queue");
            return queue;
        }

        @Bean
        public Binding binding(FanoutExchange exchange, Queue queue) {
            return BindingBuilder.bind(queue).to(exchange);
        }
    }

}

