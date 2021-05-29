package pl.festburger.user;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
