package fesva.com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DeafaultController {

    @RequestMapping("/")
    public String index()
    {
        return (new Date()).toString();
    }
}
