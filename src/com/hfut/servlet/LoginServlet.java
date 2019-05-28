package com.hfut.servlet;

import com.hfut.pojo.User;
import com.hfut.service.LoginService;
import com.hfut.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String uname=req.getParameter("uname");
        //uname=new String(uname.getBytes("iso8859-1"),"utf-8");  //解码，防止乱码
        String pwd=req.getParameter("pwd");
        System.out.println(uname);
        System.out.println(pwd);
        //处理请求信息
        LoginService ls=new LoginServiceImpl();
        User u=ls.checkLoginService(uname,pwd);
        //响应处理结果
        System.out.println(u);
        if(u!=null){
            //请求转发
            //req.getRequestDispatcher("main").forward(req,resp);

            //创建Cookie信息
            Cookie c=new Cookie("uid",u.getUid()+"");
            c.setMaxAge(3*24*3600);
            c.setPath("/manager.ck");
            resp.addCookie(c);
            //重定向
            resp.sendRedirect("/manager/main");
            return;
        }else{
            //resp.getWriter().write("登录失败");
            //使用request对象实现不同Servlet的数据流转
            req.setAttribute("str","用户名或密码错误");
            //使用请求转发
            req.getRequestDispatcher("page").forward(req,resp);
            return; //请求转发后直接return
        }
    }
}
