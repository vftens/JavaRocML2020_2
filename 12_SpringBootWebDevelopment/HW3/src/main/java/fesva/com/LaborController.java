package fesva.com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
// This is needed for the /labor
@RestController
@RequestMapping("/labor")
public class LaborController {

    @RequestMapping("/labor")
    public String index() {
        return ("index");
    }
}


