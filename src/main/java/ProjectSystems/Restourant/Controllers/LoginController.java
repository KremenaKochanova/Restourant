package ProjectSystems.Restourant.Controllers;

import ProjectSystems.Restourant.Services.CookService;
import ProjectSystems.Restourant.Services.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private CookService cookService;

    @Autowired
    private WaiterService waiterService;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (cookService.authenticate(username, password)) {
            return "redirect:/cook";
        } else if (waiterService.authenticate(username, password)) {
            return "redirect:/waiter";
        } else {
            return "redirect:/login?error=true";
        }
    }
}

