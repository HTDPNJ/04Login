package com.hfut.service;

import com.hfut.dao.LoginDao;
import com.hfut.dao.impl.LoginDaoImpl;
import com.hfut.pojo.User;

public class LoginServiceImpl implements LoginService {
    LoginDao ld=new LoginDaoImpl();
    @Override
    public User checkLoginService(String uname, String pwd) {
        return ld.checkLoginDao(uname,pwd);
    }

    @Override
    public User checkLoginService(String id) {
        return ld.checkUidDao(id);
    }
}
