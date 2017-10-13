
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Вход</title>");
            out.println("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"first_row\">");
            out.println("<p><b>Необходимо ввести учётные данные</b></p>");
            out.println("</div>");
            out.println("<div class=\"data\">");
            out.println("<table class=\"data_table\">");
            out.println("<tr>");
            out.println("<th>Имя пользователя</th>");
            out.println("<th><input type=\"text\" name=\"username\" size=\"20\"></th>");
            out.println("<th><a href=\"http://localhost:8080/Application/sign-up\">Регистрация</a></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>Пароль</th>");
            out.println("<th><input type=\"password\" size=\"20\"></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th></th>");
            out.println("<th>");
            out.println("<form action=\"http://localhost:8080/Application/welcome\" method=\"POST\">");
            out.println("<input type=\"submit\" value=\"Войти\">");
            out.println("</form>");
            out.println("</th>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/pages/signIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
