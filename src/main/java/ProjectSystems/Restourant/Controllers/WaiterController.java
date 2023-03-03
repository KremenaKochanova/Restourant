package ProjectSystems.Restourant.Controllers;

import ProjectSystems.Restourant.Entitis.Waiter;
import ProjectSystems.Restourant.Services.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/waiter")
public class WaiterController {

    @Autowired
    private WaiterService waiterService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("waiter", new Waiter());
        return "waiter-login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("waiter") Waiter waiter, HttpSession session) {
        Waiter authenticatedWaiter = waiterService.authenticateWaiter(waiter.getUsername(), waiter.getPassword());
        if (authenticatedWaiter == null) {
            return "redirect:/waiter/login?error";
        }
        session.setAttribute("waiter", authenticatedWaiter);
        return "redirect:/waiter/orders";
    }
}

