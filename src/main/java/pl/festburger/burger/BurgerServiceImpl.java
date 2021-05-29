package pl.festburger.burger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BurgerServiceImpl implements BurgerService{
    @Autowired
    private BurgerRepository burgerRepository;

    @Override
    public void save(Burger burger) {
        burgerRepository.save(burger);
    }
}
