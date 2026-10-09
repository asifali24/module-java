package com.module1.firstModule;

import com.module1.firstModule.entities.Dr;
import com.module1.firstModule.services.DrServ;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DrTest {

    @Autowired
    DrServ drServ;

    @Test
    void createDr(){
        String name = "TestDr";
        String email = "email@email.com";

        Dr newDr = drServ.createDr(name,email);

        System.out.println(newDr);

    }
}
