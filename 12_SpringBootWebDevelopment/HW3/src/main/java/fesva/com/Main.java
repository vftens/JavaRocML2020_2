package fesva.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.TimeZone;



@Configuration
@EnableJpaRepositories("fesva.com.base.*")
@ComponentScan(basePackages = { "fesva.com.base.*" })
@EntityScan("fesva.com.springboot.demo.entity")
@SpringBootApplication
public class Main{
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getDefault());
    }
}

// This Program is for testing purposes in course only