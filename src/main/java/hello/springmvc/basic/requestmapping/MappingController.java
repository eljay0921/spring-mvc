package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    Logger log = LoggerFactory.getLogger(getClass());

    // 기본 형태
    // /hello-basic, /hello-basic/ 서로 다른 형태지만 Spring이 같은 것으로 매핑해준다
    // (정정) Spring 3.0부터 위 2개 url은 서로 다른 것으로 취급된다
    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("basic");
        return "OK";
    }

    // 기본 형태 1-1
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "OK";
    }

    // 기본 형태 1-2
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "OK";
    }

    // "경로 변수" @PathVariable -> url path 내에서 변수명이 같을 때 생략할 수 있다
    // path와 변수명이 일치하면 (@PathVariable String userId) 으로 축약해도 동작한다
    // 변수명을 다르게 지정하고 싶다면 1, 그게 아니라면 2가 좋겠다
    // 1. @PathVariable("userId") String data
    // 2. @PathVariable String userId
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);
        return "OK";
    }

    // 경로 변수 (다중)
    @GetMapping("/mapping/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable int orderId) {
        log.info("mappingPath userId={} orderID={}", userId, orderId);
        return "OK";
    }

    // 조건(params)에 따른 매핑
    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "OK";
    }

    // 조건(header)에 따른 매핑
    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "OK";
    }
}
