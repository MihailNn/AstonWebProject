package com.aston.mihail.servlet;

import com.aston.mihail.dao.UserDaoIm;
import com.aston.mihail.service.HashPassword;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    String login = request.getParameter("login");
    String password = request.getParameter("password");
        UserDaoIm daoUser = new UserDaoIm();
    if(daoUser.isValid(login, HashPassword.getHash(password))) {
        request.getSession().setAttribute("login", login);
        response.sendRedirect(request.getContextPath()+"/GroupListServlet");
//        request.setAttribute("group", ListService.retrieveList());
//        request.getRequestDispatcher("WEB-INF/welcome.jsp").
//                forward(request, response);…
    }
    else {
        request.setAttribute("errorMessage", "Invalid Login or password!!!");
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").
                forward(request,response);
    }
    }

}
