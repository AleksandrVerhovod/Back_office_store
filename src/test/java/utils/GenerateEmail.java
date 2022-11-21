package utils;

import com.github.javafaker.Faker;

public class GenerateEmail {

    public static Faker faker;

    public static String generateEmail() {
        faker = new Faker();
        return faker.letterify("????????@test.ru");
    }
    public static String generateMinEmail() {
        faker = new Faker();
        return faker.letterify("?@te.ru");
    }
    public static String generateMinMinus1Email() {
        faker = new Faker();
        return faker.letterify("?@e.ru");
    }

    public static String generateEmailMinPlus1() {
        faker = new Faker();
        return faker.letterify("??@te.ru");
    }

    public static String generateEmailMax() {
        faker = new Faker();
        return faker.letterify("?????????????.??????_????????????????????@test.com");
    }

    public static String generateEmailMaxMinus1() {
        faker = new Faker();
        return faker.bothify("####?????????????????????????????????###@test.com");
    }
    public static String generateEmailMaxPlus1() {
        faker = new Faker();
        return faker.letterify("?????????????????????????????????????????1@test.com");
    }
    public static String generateEmailUPPERCase() {
        faker = new Faker();
        return faker.letterify("TEST???@test.com");
    }

    public static String generateEmailWithSpaces() {
        faker = new Faker();
        return faker.letterify(" ????????@test.com ");
    }

    public static String generateEmailWithCyrillic() {
        faker = new Faker();
        return faker.letterify(" ТЕСТ????@test.com ");
    }

    public static String generateEmailWithDotBegin() {
        faker = new Faker();
        return faker.letterify(".???????@test.com");
    }

    public static String generateEmailWithout_a() {
        faker = new Faker();
        return faker.letterify("???????test.com");
    }

    public static String generateEmailWithoutDot() {
        faker = new Faker();
        return faker.letterify("???????@testcom");
    }

    public static String generateEmailWithEmptyLocal() {
        faker = new Faker();
        return faker.letterify("@test.com");
    }

    public static String generateEmailWithEmptyDomen() {
        faker = new Faker();
        return faker.letterify("????????@");
    }

    public static String generateEmailOnlySpaces() {
        faker = new Faker();
        return faker.letterify("           ");
    }

    public static String generateEmailSpecChars() {
        faker = new Faker();
        return faker.letterify("??_??.??@test.com");
    }


}
