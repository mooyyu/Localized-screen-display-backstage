package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin("http://localhost:8080")
@RequestMapping("/chartData/overview")
public class OverviewChartDataController {
    @RequestMapping(value = "/", method = {RequestMethod.GET})
    @ResponseBody
    public String PrintHelloWorld() {
        return "hello, world.";
    }
}
