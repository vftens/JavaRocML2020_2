package fesva.com.RestApi;

import org.alicebot.ab.cli.MyMain;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Main{
    public static void main(String[] args) {
        MyMain.main(args);  // 1.	Искусственный Интеллект на Джава, с ним можно пообщаться на английском языке.

        SpringApplication.run(Main.class, args);    //  2. Теперь, что-то с pom.xml,  Spring не запускается Ошибка
        // Exception in thread "main" java.lang.ClassCastException: class org.apache.logging.slf4j.SLF4JLoggerContext cannot be cast to class org.apache.logging.log4j.core.LoggerContext
    }
}