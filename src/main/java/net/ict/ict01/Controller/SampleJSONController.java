package net.ict.ict01.Controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class SampleJSONController {

    @GetMapping("/helloArr")
    public String[] helloArr(){
        log.info("hello Arr~~~~~");
        return new String[]{"AAA","BBB","CCC"};

    }

}
