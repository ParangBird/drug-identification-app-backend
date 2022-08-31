package sotree.dia.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        log.info("hello {}", request.getRemoteHost());
        return "hello";
    }
}
