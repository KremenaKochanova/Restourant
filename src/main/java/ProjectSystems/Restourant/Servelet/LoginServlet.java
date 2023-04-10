package ProjectSystems.Restourant.Servelet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

         if (role.equals("cook")) {
            response.sendRedirect("WelcomeCook.html");
        } else if (role.equals("waiter")) {
            response.sendRedirect("WelcomeWaiter.html");
        } else {
            // Ако потребителят не е готвач или сервитьор, можете да го пренасочите към грешна страница
            response.sendRedirect("error-page.html");
        }
    }
}

//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        String role = request.getParameter("role");
//
//        // JDBC connection variables
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            // Establishing connection with the database
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restourant", "username", "password");
//
//
//            // Creating the query to retrieve the user based on the provided name and password
//            String query = "SELECT * FROM cook WHERE name = ? AND password = ? UNION SELECT * FROM waiter WHERE name = ? AND password = ?";
//
//
//            statement = connection.prepareStatement(query);
//            statement.setString(1, name);
//            statement.setString(2, password);
//
//            // Executing the query and retrieving the result
//            resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                // If the user exists in the database, redirect to the appropriate page based on their role
//                if (role.equals("cook")) {
//                    response.sendRedirect("WelcomeCook.html");
//                } else if (role.equals("waiter")) {
//                    response.sendRedirect("WelcomeWaiter.html");
//                } else {
//                    response.sendRedirect("error-page.html");
//                }
//            } else {
//                // If the user does not exist in the database, redirect to the error page
//                response.sendRedirect("error-page.html");
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            // Handling any exceptions that might occur during the database connection or query execution
//            e.printStackTrace();
//        } finally {
//            // Closing the database resources
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (statement != null) {
//                    statement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

