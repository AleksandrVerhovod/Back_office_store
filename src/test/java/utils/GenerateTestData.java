package utils;

import com.github.javafaker.Faker;

public class GenerateTestData {
    public static Faker faker;
    public static String generateEmail() {
        faker = new Faker();
        return faker.letterify("???????????@test.com");
    }

    public static String generatePassword() {
        faker = new Faker();
        return faker.letterify("????????@1");
    }
    public static String generateName() {
        faker = new Faker();
        return faker.name().firstName();
    }

    public static int generatePrice() {
        faker = new Faker();
        return faker.number().randomDigitNotZero();
    }
    public static String generateCategory() {
        faker = new Faker();
        return faker.pokemon().name();
    }

}
