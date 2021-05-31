package pl.festburger.burger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BurgerRepository extends JpaRepository<Burger, Long> {

    @Query("select b.price from Burger b where b.id = ?1")
    String findPriceById (Long Id);

    @Query(value = "select b.* from burgers b where b.id = ?1", nativeQuery = true)
    Burger findBurgerById (Long Id);
}
