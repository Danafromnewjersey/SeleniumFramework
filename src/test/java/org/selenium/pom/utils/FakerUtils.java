package org.selenium.pom.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public Long generateRandomName(){
        Faker faker = new Faker();
//        return faker.number().randomNumber();
        return faker.number().randomNumber(10, true);
    }
}
