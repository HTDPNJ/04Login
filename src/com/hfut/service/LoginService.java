package com.hfut.service;

import com.hfut.pojo.User;

public interface LoginService  {
    User checkLoginService(String uname,String pwd);
    User checkLoginService(String id);
}
