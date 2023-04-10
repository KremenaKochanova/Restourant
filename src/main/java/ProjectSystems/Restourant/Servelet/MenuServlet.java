package ProjectSystems.Restourant.Servelet;

import ProjectSystems.Restourant.Entitis.Dish;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restourant", "name", "password");

            // Execute a query to get all dishes
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM dishes");

            // Convert the result set to a list of Dish objects
            List<Dish> dishes = new ArrayList<>();
            while (rs.next()) {
                String type = null;
                String name = null;
                double price = 0;
                Dish dish = new Dish(name, type, price);
                dish.setId((int) rs.getInt("id"));
                dish.setName(rs.getString("name"));
                dish.setType(rs.getString("type"));
                dish.setPrice(rs.getDouble("price"));
                dishes.add(dish);
            }

            // Set the dishes as an attribute of the request
            request.setAttribute("dishes", dishes);

            // Forward the request to the JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("/menu.jsp");
            dispatcher.forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }
}
