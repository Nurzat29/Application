<%-- 
    Document   : signInJsp
    Created on : Oct 12, 2017, 9:56:11 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Вход</title>
    </head>
    <body>
        <form action="StartServlet" method="POST">
            Имя пользователя<input type="text" name="username">
            <a href="<%= request.getContextPath() %>/sign-up">Регистрация</a>
            <p>Пароль<input type="text" name="password"></p>
            <input type="submit" value="Войти">
        </form>
    </body>
</html>
