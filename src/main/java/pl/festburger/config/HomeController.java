package pl.festburger.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.festburger.burger.Burger;
import pl.festburger.burger.BurgerService;

@Controller
public class HomeController {

    @Autowired
    private BurgerService burgerService;

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "home";
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("burgerForm", new Burger());
        return "admin";
    }

    @PostMapping("/admin")
    public String admin(@ModelAttribute("burgerForm") Burger burgerForm) {
        burgerService.save(burgerForm);
        return "redirect:/admin";
    }

    @GetMapping("/menu")
    public String menu(){
        return "menu";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
