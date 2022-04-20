package testPackage.Servlet;

import testPackage.DB.User;
import testPackage.DB.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
        System.out.println("я тут");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (userDAO.checkUserLogin(request.getParameter("login")) == null) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            User newUser = new User(login, password, name, email);
            try {
                userDAO.insertUser(newUser);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("message", "Аккаунт создан");
            request.setAttribute("color", "green");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("message", "Данный логин уже занят");
            request.setAttribute("color", "red");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
        }
    }
}
