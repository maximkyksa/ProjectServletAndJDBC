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
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    //private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
        System.out.println("я тут");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test " + request.getParameter("login") + request.getParameter("password"));
        User user = userDAO.checkUser(request.getParameter("login"), request.getParameter("password"));
        //if (userDAO.checkUser(request.getParameter("login"), request.getParameter("password")) == null) {
        if (user == null) {
            request.setAttribute("message", "Пользователь не существует или некорректно введ логин или пароль");
            request.setAttribute("color", "red");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            if (user.getSuper_user() == 1) {
                listUser(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/userTable.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<User> users = userDAO.selectAllUsers();
        for (User user : users) {
            System.out.println(user.getId());
        }
        request.setAttribute("usersList", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTable.jsp");
        dispatcher.forward(request, response);
    }
}
