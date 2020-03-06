package com.wallet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * HelloWord
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWord {

    @Test
    public void testeHelloWord(){
        assertEquals(1, 1);
    }
}