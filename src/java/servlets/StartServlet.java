
package servlets;

import JavaBeans.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("message", "");
        request.getSession().setAttribute("success", "");
        request.getSession().setAttribute("newUserMessage", "");
        request.getSession().setAttribute("exit", "");
        response.sendRedirect(request.getContextPath() + "/sign-in");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        System.out.println(username);
        System.out.println(password);
        //Map<String, String> messages = new HashMap<String, String>();
        String message = new String();

        User user = new User("Sergei123", "123123Qw");
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            message = "Необходимо ввести учётные данные";
            //messages.put("username", "Please enter username");
        } else if(!(username.equals(user.getUsername())) || !(password.equals(user.getPassword()))) {
            message = "Имя пользователя и пароль не подходят";
        }

        /* if (password == null || password.isEmpty()) {
            messages.put("password", "Please enter password");
        }*/
        
        if(message.isEmpty()) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/welcome");
        }

        /*if (messages.isEmpty()) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/welcome");
        }*/
        /*if (messages.isEmpty()) {
            System.out.println();

            if (user != null) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/home");
                return;
            } else {
                messages.put("login", "Unknown login, please try again");
            }  
        }*/
        else {
            request.getSession().setAttribute("message", message);
            response.sendRedirect(request.getContextPath() + "/sign-in");
            }
            //request.setAttribute("messages", messages);
            //request.getRequestDispatcher("/pages/signIn.jsp").forward(request, response);

    }
}

