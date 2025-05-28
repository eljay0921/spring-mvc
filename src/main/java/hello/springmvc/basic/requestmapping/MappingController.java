package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    Logger log = LoggerFactory.getLogger(getClass());

    // 기본 형태
    // /hello-basic, /hello-basic/ 서로 다른 형태지만 Spring이 같은 것으로 매핑해준다
    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("basic");
        return "OK";
    }

    // 다중 설정
    @RequestMapping({"/hello-basic2", "/hello-basic3"})
    public String helloBasic2() {
        log.info("basic2 or 3");
        return "OK";
    }

    // Method 설정 방법 1
    @RequestMapping(value = "/hello-basic4", method = RequestMethod.POST)
    public String helloBasic4() {
        log.info("basic4 is POST");
        return "OK";
    }

    // Method 설정 방법 2
    @DeleteMapping("/hello-basic5")
    public String helloBasic5() {
        log.info("basic5 is DELETE");
        return "OK";
    }
}
