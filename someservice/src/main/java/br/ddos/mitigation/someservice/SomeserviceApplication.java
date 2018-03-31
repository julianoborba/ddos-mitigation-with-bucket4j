package br.ddos.mitigation.someservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SomeserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SomeserviceApplication.class, args);
    }
}
