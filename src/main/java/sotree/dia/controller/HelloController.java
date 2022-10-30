package sotree.dia.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        log.info("hello {}", request.getRemoteHost());
        return "hello";
    }
    @GetMapping(value = "/image-test", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] hello() throws IOException {
        InputStream in = getClass().getResourceAsStream("/images/logo.png");
        return IOUtils.toByteArray(in);
    }
}
