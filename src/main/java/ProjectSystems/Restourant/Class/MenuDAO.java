package ProjectSystems.Restourant.Class;

import java.awt.*;
import java.util.ArrayList;

public interface MenuDAO {
    ArrayList<Menu> getAllItems();

    Menu getItemById(int id);

    ArrayList<Menu> getItemsByType(String type);

    void addItem(Menu item);

    void updateItem(Menu item);

    void deleteItem(int id);
}

