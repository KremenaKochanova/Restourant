package ProjectSystems.Restourant.Controllers;

import ProjectSystems.Restourant.Entitis.Cook;
import ProjectSystems.Restourant.Services.CookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
    @RequestMapping("/cook")
    public class CookController {

        @Autowired
        private CookService cookService;

        @GetMapping("/login")
        public String showLoginForm(Model model) {
            model.addAttribute("cook", new Cook());
            return "cook-login";
        }

        @PostMapping("/login")
        public String login(@ModelAttribute("cook") Cook cook, HttpSession session) {
            Cook authenticatedCook = CookService.authenticateCook(cook.getUsername(), cook.getPassword());
            if (authenticatedCook == null) {
                return "redirect:/cook/login?error";
            }
            session.setAttribute("cook", authenticatedCook);
            return "redirect:/cook/orders";
        }
    }


