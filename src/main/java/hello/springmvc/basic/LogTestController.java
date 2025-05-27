package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring MVC";

        log.trace("[TRACE] log={}", name);
        log.debug("[DEBUG] log={}", name);
        log.info("[INFO] log={}", name);
        log.warn("[WARN] log={}", name);
        log.error("[ERROR] log={}", name);

        return "Logging OK";
    }
}
