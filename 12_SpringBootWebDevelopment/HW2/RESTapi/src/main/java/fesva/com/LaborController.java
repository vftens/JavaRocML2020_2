package fesva.com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LaborController {

    @RequestMapping("/labor")
    public String index() {

        Random rnd = new fesva.com.Random();

        if (rnd.nextBoolean()) {
            return (new Date()).toString();
        } else {
            return String.valueOf((new Random().nextInt()));
        }
    }

}


