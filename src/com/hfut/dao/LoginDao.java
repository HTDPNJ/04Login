package com.hfut.dao;

import com.hfut.pojo.User;

public interface LoginDao {
    User checkLoginDao(String uname,String pwd);
    User checkUidDao(String uid);
}
