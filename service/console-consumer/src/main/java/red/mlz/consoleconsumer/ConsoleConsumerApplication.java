package red.mlz.consoleconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ConsoleConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsoleConsumerApplication.class, args);
    }

}
