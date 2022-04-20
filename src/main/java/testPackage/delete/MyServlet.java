package testPackage.delete;

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
import java.util.List;

@WebServlet(urlPatterns = "/new")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
        System.out.println("я тут");
    }

    /* @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html;charset=UTF-8");
         //String path = req.getParameter("Country").equals("ru")? "/ru.jsp":"/ru.jsp";
         req.setAttribute("name",req.getParameter("Name"));
         req.setAttribute("age",req.getParameter("Age"));
         req.setAttribute("country",req.getParameter("Country"));
         req.getRequestDispatcher("/login.jsp").forward(req, resp);
     }/

     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/checkPassword":
                    checkPassword(request, response);
                    break;
                case "/register":
                    showRegisterForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                default:
                    showLoginAndRegisterForm(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> users = userDAO.selectAllUsers();
        for (User user : users) {
            System.out.println(user.getId());
        }
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTable.jsp");
        dispatcher.forward(request, response);
    }

    private void checkPassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        System.out.println("test " + request.getParameter("login") + request.getParameter("password"));
        if (userDAO.checkUser(request.getParameter("login"), request.getParameter("password")) == null) {
            request.setAttribute("message", "Пользователь не существует или некорректно введ логин или пароль");
            request.setAttribute("color", "red");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            listUser(request, response);
        }
    }

    private void showLoginAndRegisterForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        if (userDAO.checkUserLogin(request.getParameter("login")) == null) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            User newUser = new User(login, password, name, email);
            userDAO.insertUser(newUser);
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
        //response.sendRedirect("list");
    }

}

