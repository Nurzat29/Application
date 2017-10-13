
package servlets;

import JavaBeans.User;
import check.CheckUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class CheckNewUserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckNewUserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckNewUserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User user = new User("Ivan12", "123456Qw");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String repeatPassword = request.getParameter("repeatPassword").trim();
        System.out.println(username);
        System.out.println(password);
        System.out.println(repeatPassword);
        String newUserMessage = new String();
   
        if(username.length() < 5 || CheckUser.IsRussian(username) || !(CheckUser.haveNumber(username))) {
            newUserMessage = "Имя пользователя должно быть длиннее 4 символов и состоять из цифр и букв английского алфавита";
        } else if(password.isEmpty()) {
            newUserMessage = "Заполните поле \"Пароль\"";
        } else if(!(password.equals(repeatPassword))) {
            newUserMessage = "Пароль и повтор пороля не совпадают";
        } else if(password.length() < 8 || !(CheckUser.haveNumber(password)) || !(CheckUser.haveUpperCase(password)) || 
                !(CheckUser.haveLowerCase(password))) {
            newUserMessage = "Пароль недостаточно сложен: должны быть цифры, заглавные и строчные буквы и длина минимум 8 символов";
        } else if(username.toLowerCase().equals(user.getUsername().toLowerCase())) {
            newUserMessage = "Пользователь с таким именем уже зарегистрирован";
        }
        
        if(newUserMessage.isEmpty()) {
            //request.getSession().setAttribute("success", "Регистрация прошла успешно");
            request.getSession().setAttribute("message", "");
            request.getSession().setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/welcome");
        } else {
            request.getSession().setAttribute("newUserMessage", newUserMessage);
            response.sendRedirect(request.getContextPath() + "/sign-up");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
