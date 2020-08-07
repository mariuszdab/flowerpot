package pl.mariuszdab.flowerpot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FlowerpotApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowerpotApplication.class, args);
    }

}
