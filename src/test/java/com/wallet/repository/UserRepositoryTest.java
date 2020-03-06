package com.wallet.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import com.wallet.entity.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserRepositoryTest
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    private static final String EMAIL = "email@teste.com";

    @Autowired
    UserRepository reposiroty;

    @Before
    public void setUp(){
        User user = new User();

        user.setName("Set up User");
        user.setPassword("Senha123");
        user.setEmail(EMAIL);

        reposiroty.save(user);
    }

    @After
    public void tearDown(){
        reposiroty.deleteAll();
    }

    @Test
    public void testeSave(){
        User user = new User();
        
        user.setName("Teste");
        user.setEmail("lucas@teste.com.br");
        user.setPassword("123");
        
        User response = reposiroty.save(user);

        assertNotNull(response);
    }

    @Test
    public void testeFinfByEmail(){
        Optional<User> response = reposiroty.findByEmailEquals(EMAIL);

        assertTrue(response.isPresent());
        assertEquals(response.get().getEmail(), EMAIL);
    }
}