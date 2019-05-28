package com.hfut.dao.impl;

import com.hfut.dao.LoginDao;
import com.hfut.pojo.User;

import java.sql.*;


public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkLoginDao(String uname, String pwd) {
        //声明jdbc对象
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User u=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","12345678");
            String sql="select * from t_user where uname=? and pwd=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,pwd);
            rs=ps.executeQuery();
            while(rs.next()){
                u=new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //加载驱动
        //获取连接对象
        //创建sql对象
        return u;
    }

    @Override
    public User checkUidDao(String uid) {
        //声明jdbc对象
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User u=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","12345678");
            String sql="select * from t_user where uid=? ";
            ps=conn.prepareStatement(sql);
            ps.setString(1,uid);
            rs=ps.executeQuery();
            while(rs.next()){
                u=new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //加载驱动
        //获取连接对象
        //创建sql对象
        return u;
    }
}
