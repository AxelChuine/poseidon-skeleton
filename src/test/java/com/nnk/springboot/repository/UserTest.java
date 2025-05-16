package com.nnk.springboot.repository;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testUser() {
        User user = new User("fullName", "username", "password");

        // Save
        user = repository.save(user);
        Assertions.assertNotNull(user.getId());
        Assertions.assertTrue(user.getId() == 13);

        // Update
        user.setId(14);
        user = repository.save(user);
        Assertions.assertTrue(user.getId() == 14);

        // Find
        List<User> listResult = repository.findAll();
        Assertions.assertTrue(listResult.size() > 0);

        // Delete
        Integer id = user.getId();
        repository.delete(user);
        Optional<User> optional = repository.findById(id);
        Assertions.assertFalse(optional.isPresent());
    }
}
