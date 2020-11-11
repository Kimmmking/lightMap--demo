package com.example.demo.controller;

import com.example.demo.pojo.MyResponseBody;
import com.example.demo.pojo.ResponseBodyController;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getMap")
    public Object getMap(){
        ResponseBodyController responseBodyController = new ResponseBodyController();
        return new MyResponseBody("200", "success", userService.getAll());
    }

    @PostMapping("/addUser")
    @ResponseBody()
    public Object addUser(@RequestBody User user){
        ResponseBodyController responseBodyController = new ResponseBodyController();
        if (user.getUserId().equals("") || user.getLat() == null || user.getLng() == null){
            MyResponseBody myResponseBody = new MyResponseBody("600", "param is null", null);
            return responseBodyController.handleResponse(myResponseBody);
        }
        return new MyResponseBody("200", "success", userService.add(user));
    }
}
