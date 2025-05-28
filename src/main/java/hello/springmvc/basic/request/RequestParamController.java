package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));
        log.info("requestParamV1 : username={}, age={}", username, age);
        resp.getWriter().write("OK");
    }

    // @Controller 클래스에서 String을 return하면 view의 논리적 이름으로 인식한다. (지금 테스트 목적에 맞지 X)
    // -> (1) 클래스를 @RestController로 바꾸는 방법
    // -> (2) 매핑 함수에 @ResponseBody를 추가하는 방법이 있다.
    // 여기서는 (2)으로 해보자
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int memberAge) {
        log.info("requestParamV2 : username={}, age={}", memberName, memberAge);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age) {
        log.info("requestParamV3 : username={}, age={}", username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("requestParamV4 : username={}, age={}", username, age);
        return "OK";
    }

    // required 속성 활용하기
    // 대신 age에 null이 들어올 수 있으므로 int → Integer로 변경
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username,
                                       @RequestParam(required = false) Integer age) {
        log.info("requestParamRequired : username={}, age={}", username, age);
        return "OK";
    }

    // null 방어를 위한 defaultValue 속성 활용하기
    // -> 기본 값(defaultValue)을 적용하기에, required 속성도 함께 사용할 수 있지만 그다지 의미는 없다
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(defaultValue = "guest") String username,
                                       @RequestParam(defaultValue = "-1") int age) {
        log.info("requestParamDefault : username={}, age={}", username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("requestParamMap : username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "OK";
    }
}
