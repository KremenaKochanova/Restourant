package ProjectSystems.Restourant.Servelet;

import ProjectSystems.Restourant.Class.DishDao;
import ProjectSystems.Restourant.Entitis.Dish;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/createDish")
public class CreateDishServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("createDish.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));

        Dish dish = new Dish(name, type, price);

        DishDao dishDао = new DishDao() {
            @Override
            public List<Dish> getAllDishes() {
                return null;
            }

            @Override
            public Dish getDishById(int id) {
                return null;
            }

            @Override
            public void createDish(Dish dish) {
            }

            @Override
            public void updateDish(Dish dish) {
            }

            @Override
            public void deleteDish(int id) {
            }
        };
        dishDао.createDish(dish);

        response.sendRedirect("menu");
    }
}

