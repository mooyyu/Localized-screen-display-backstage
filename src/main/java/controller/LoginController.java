package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.LoginInfo;
import service.BackStageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin
@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
public class LoginController {
    private final BackStageService backStageService;
    @Autowired
    public LoginController(BackStageService backStageService) {
        this.backStageService = backStageService;
    }

    @RequestMapping(value = "checkLogin", method = {RequestMethod.POST})
    @ResponseBody
    public String checkLogin(@RequestBody LoginInfo loginInfo, HttpServletRequest request) {
        return backStageService.checkLogin(loginInfo, request);
    }

    @RequestMapping(value = "checkIsLogin", method = {RequestMethod.GET})
    @ResponseBody
    public String checkIsLogin(HttpServletRequest request) {
        return backStageService.checkIsLogin(request);
    }

    @RequestMapping(value = "/getVCode", method = {RequestMethod.GET})
    public void getVCode(HttpServletRequest request, HttpServletResponse response) {
        backStageService.getVCode(request, response);
    }
}
