package fesva.com.RestApi;

//import com.dropbox.core.v2.DbxClientV2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Main{
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }
}