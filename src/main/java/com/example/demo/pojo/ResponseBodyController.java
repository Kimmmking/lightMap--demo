package com.example.demo.pojo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResponseBodyController {
    @ResponseBody
    public Map<String, Object> handleResponse(MyResponseBody responseBody){
        Map<String, Object> result =  new HashMap<>();
        result.put("code", responseBody.code);
        result.put("msg", responseBody.msg);
        result.put("data", responseBody.data);
        return result;
    }
}
