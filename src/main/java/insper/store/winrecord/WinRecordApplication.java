package insper.store.winrecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class WinRecordApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinRecordApplication.class, args);
    }
    
}
