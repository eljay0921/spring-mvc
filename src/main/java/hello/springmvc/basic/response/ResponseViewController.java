package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mv = new ModelAndView("response/hello").addObject("data", "hello~~");
        return mv;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello~!");
        return "response/hello";
    }

    // 주의 : @ResponseBody 사용 시, 뷰 템플릿이 아닌 String 그대로 반환
    @ResponseBody
    @RequestMapping("/response-view-v3")
    public String responseViewV3(Model model) {
        model.addAttribute("data", "hello~!");
        return "response/hello";
    }

    @RequestMapping("/response/hello")
    public void responseViewV4(Model model) {
        model.addAttribute("data", "hello@@@");
    }
}
