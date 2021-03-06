package pl.festburger.order;

import pl.festburger.burger.Burger;
import pl.festburger.user.User;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String totalPrice;

    @OneToOne
    @JoinColumn(name="user_id", unique = true)
    private User user;

    @OneToMany
    private List<Burger> burgerList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Burger> getBurgerList() {
        return burgerList;
    }

    public void setBurgerList(List<Burger> burgerList) {
        this.burgerList = burgerList;
    }
}

