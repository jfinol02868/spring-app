package com.spring.app.spring.app.repository.impl;

import com.spring.app.spring.app.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static int userId = 0;
    private static List<User> users = new ArrayList<>();
    private static final Logger LOG = LoggerFactory.getLogger(UserDaoService.class);

    static {
        users.add(new User(userId++, "Jesus", LocalDate.now().minusYears(30)));
        users.add(new User(userId++, "Jose", LocalDate.now().minusYears(20)));
        users.add(new User(userId++, "Juan", LocalDate.now().minusYears(27)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user){
        user.setId(userId ++);
        users.add(user);
        return new User(user.getId(), user.getName(), user.getBirthDate());
    }

    public User findOne(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.remove(users.stream().filter(predicate).findFirst().orElse(null));
    }
}
