package com.example.client.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;

@RunWith(SpringRunner.class)
public class ClientDTOTest {

    @Test
    public void getAgeTest() {
        //when
        ClientDTO client = new ClientDTO();
        client.setName("Daniel");
        client.setSureName("Miralles");
        client.setBirthDate(LocalDate.of(1985, Month.OCTOBER, 23));

        //expect
        int age = client.getAge();

        //then
        Assert.assertEquals(age, 33);
    }
}
