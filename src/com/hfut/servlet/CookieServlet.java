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
/*cookie信息校验
* 判断是否携带正确的信息*/
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Cookie[]cks=req.getCookies();
        if(cks!=null){
            //遍历Cookie信息
            String uid="";
            for( Cookie c:cks){
                if("uid".equals(c.getName())){
                    uid=c.getValue();
                }
            }
            if("".equals(uid)){
                //请求转发
                req.getRequestDispatcher("page").forward(req,resp);
                return;
            }else{
                LoginService ls=new LoginServiceImpl();
                User u=ls.checkLoginService(uid);
                if(u!=null){
                    resp.sendRedirect("/main");
                    return;
                }else{
                    //请求转发
                    req.getRequestDispatcher("page").forward(req,resp);
                    return;
                }
            }
        }else{
            //请求转发
            req.getRequestDispatcher("page").forward(req,resp);
            return;
        }
    }
}
