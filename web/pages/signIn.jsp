
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Вход</title>
    </head>
    <body>
        <p><%= request.getSession().getAttribute("message") %>
           <%= request.getSession().getAttribute("success")%>
           <%= request.getSession().getAttribute("exit")%>
           <% request.getSession().setAttribute("message", "");%>
           <% request.getSession().setAttribute("success", "");%>
           <% request.getSession().setAttribute("exit", "");%>
        </p>
        
        <form action="StartServlet" method="POST">
            Имя пользователя<input type="text" name="username">
            <a href="<%= request.getContextPath() %>/sign-up">Регистрация</a>
            <p>Пароль<input type="text" name="password"></p>
            <input type="submit" value="Войти">
        </form>
    </body>
</html>
