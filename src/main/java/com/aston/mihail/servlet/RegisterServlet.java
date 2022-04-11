package com.aston.mihail.servlet;

import com.aston.mihail.dao.UserDaoIm;
import com.aston.mihail.model.User;
import com.aston.mihail.service.HashPassword;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("newLoginName");
        String password = request.getParameter("newPassword");
        UserDaoIm daoUser = new UserDaoIm();
        User user = new User(name, HashPassword.getHash(password));
        if (daoUser.insertUser(user)) {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward( request, response);
        } else{
            request.setAttribute("errorRegister", "Выберите другое имя, такой пользователь существет");
            request.getRequestDispatcher("/WEB-INF/views/register.jsp") .forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/register.jsp")
                .forward(request, response);
    }
}
