
package red.mlz.appconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppConsumerApplication.class, args);
    }
}