package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.Admin;
import com.thesis.model.abstracts.User;
import com.thesis.service.interfaces.IUserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class UserManangmentBean extends AbstractBean {

    @ManagedProperty("#{userService}")
    private IUserService userService;

    private List<User> userList;

    public void init() {
        userList = new ArrayList<User>();
        for(User user : userService.retrieveAll()) {
            if (user instanceof Admin == false) {
                userList.add(user);
            }
        }
    }

    public void changeStatus(User user) {
        userService.update(user);
        showMessage("Değişiklik uygulandı!");
    }

    @Override
    public IUserService getUserService() {
        return userService;
    }

    @Override
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
