package fesva.com.RestApi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LaborController {

    @RequestMapping("/labor")
    public String index() { //

        fesva.com.RestApi.Random rnd = new fesva.com.RestApi.Random();

        if (rnd.nextBoolean()) {
            return (new Date()).toString();
        } else {
            return String.valueOf((new fesva.com.RestApi.Random().nextInt()));
        }
    }

}


