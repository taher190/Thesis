package com.thesis.controller;

import com.thesis.model.User;
import com.thesis.service.interfaces.IUserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    @ManagedProperty("#{userService}")
    private IUserService userService;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setName("ilk deneme");
        userService.save(user);
    }

    public String getName() {
        return "Hi!";
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
