package it.stacja.springfunapp;

import it.stacja.springfunapp.tinyspring.TinySpringContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringfunappApplication.class)
public class SpringfunappApplicationTest {

    @Autowired
    private TinySpringContext tinySpringContext;

    @Test
    public void name() throws Exception {
        System.out.println(tinySpringContext);
    }
}