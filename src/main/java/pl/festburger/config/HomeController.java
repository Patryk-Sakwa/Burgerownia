package pl.festburger.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.festburger.burger.Burger;
import pl.festburger.burger.BurgerRepository;
import pl.festburger.burger.BurgerService;
import pl.festburger.order.Order;
import pl.festburger.order.OrderRepository;
import pl.festburger.user.UserRepository;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class HomeController {

    public static final Logger LOG = Logger.getLogger(String.valueOf(HomeController.class));

    @Autowired
    private BurgerRepository burgerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BurgerService burgerService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public String welcome(Model model) {
        return "home";
    }

    @GetMapping("/profile")
    public String profile() {
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
    public String menu(Model model) {
        List<Burger> burgers = burgerRepository.findAll();
        model.addAttribute("burgers", burgers);
        return "menu";
    }

    @PostMapping("/menu")
    public String postMenu(@RequestParam List<String> idOfBurger) {
        LOG.warning(idOfBurger.toString());
        Double totalPrice = 0.0;
        for (int i = 0; i < idOfBurger.size(); i++) {
            totalPrice += Double.parseDouble(burgerRepository.findPriceById(Long.parseLong(idOfBurger.get(i))));
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Order order = new Order();
        order.setTotalPrice(totalPrice.toString());
        List<Burger> burgers = new ArrayList<>();
        for (int i = 0; i < idOfBurger.size(); i++) {
            burgers.add(burgerRepository.findBurgerById(Long.parseLong(idOfBurger.get(i))));
        }
        order.setBurgerList(burgers);
        order.setUser(userRepository.findByUsername(auth.getName()));
        orderRepository.save(order);
        return "redirect:/checkout";

    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }


    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }
}
