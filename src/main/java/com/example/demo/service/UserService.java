package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.pojo.User;
import com.example.demo.util.LocationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public List<User> getAll(){
        return userDAO.findAll();
    }

    public User add(User user){
        User temp = userDAO.findByUserId(user.getUserId());
        if(temp != null){
            user =  temp;
        }else{
            user = userDAO.save(user);
        }

//      根据经纬度求地区
        String lat = String.valueOf(user.getLat());
        String lng = String.valueOf(user.getLng());
        user.setArea(LocationUtil.getLocation(lat, lng));
        return user;
    }




}
