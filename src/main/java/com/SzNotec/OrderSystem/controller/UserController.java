package com.SzNotec.OrderSystem.controller;

import com.SzNotec.OrderSystem.entity.User;
import com.SzNotec.OrderSystem.service.IUserService;
import com.SzNotec.OrderSystem.util.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Resource
    private IUserService userService;

    @Resource
    private HttpServletRequest request;

    @ResponseBody
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ResponseData signin(){

        String authStr = request.getHeader("Authorization");

        System.out.println("From request : Authorization - " + authStr);

        if (null != authStr && authStr.split(":").length == 2
                && authStr.split(":")[0].length() > 0
                && authStr.split(":")[1].length() > 0 ) {

            User user = userService.signIn(authStr.split(":")[0], authStr.split(":")[1]);
            return new ResponseData(user);
        } else {

            User user = userService.signIn("yimengchun", "yimengchun");

            Map map = new HashMap<String, String>();
            map.put("STATUS", "FAIL");
            map.put("ERRMSG", "100");

            return new ResponseData(map);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/singup", method = RequestMethod.GET)
    public ResponseData signup(){
        String authStr = request.getHeader("Authorization");
        System.out.println("From request : Authorization - " + authStr);

        User user = userService.signIn(authStr.split(":")[1], authStr.split(":")[2]);
        return new ResponseData(user);
    }
}
