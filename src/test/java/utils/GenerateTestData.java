package utils;

import com.github.javafaker.Faker;

public class GenerateTestData {
    public static Faker faker;
    public static String generateEmail() {
        faker = new Faker();
        return faker.letterify("???????????@grood.com");
    }

    public static String generatePassword() {
        faker = new Faker();
        return faker.letterify("????????@1");
    }
    public static String generateName() {
        faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateJob() {
        faker = new Faker();
        return faker.job().title();
    }

}
