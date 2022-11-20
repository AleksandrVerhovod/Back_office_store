package utils;

import com.github.javafaker.Faker;

public class GeneratePassword {
    public static Faker faker;

    public static String generatePassword() {
        faker = new Faker();
        return faker.letterify("??????Q@1");
    }

    public static String generatePasswordMin() {
        faker = new Faker();
        return faker.letterify("???Q@1");
    }

    public static String generatePasswordMax() {
        faker = new Faker();
        return faker.letterify("?????????????????Q@1");
    }

    public static String generatePasswordWithSpacesBeginAndEnd() {
        faker = new Faker();
        return faker.letterify(" ????Q@1 ");
    }
    public static String generatePasswordMinPlus1() {
        faker = new Faker();
        return faker.letterify("????Q@1");
    }
    public static String generatePasswordMaxMinus1() {
        faker = new Faker();
        return faker.letterify("????????????????Q@1");
    }

    public static String generatePasswordWithSpecChars() {
        faker = new Faker();
        return faker.letterify("??????Q@#&/!-.%$1");
    }

    public static String generatePasswordMinMinus1() {
        faker = new Faker();
        return faker.letterify("??Q@1");
    }

    public static String generatePasswordMaxPlus1() {
        faker = new Faker();
        return faker.letterify("??????????????????Q@1");
    }

    public static String generatePasswordLowerCase() {
        faker = new Faker();
        return faker.letterify("string@#");
    }

    public static String generatePasswordUpperCase() {
        faker = new Faker();
        return faker.bothify("STRING@#");
    }

    public static String generatePasswordWithoutSpecChar() {
        faker = new Faker();
        return faker.letterify("???????Q1");
    }

    public static String generatePasswordWithoutNumber() {
        faker = new Faker();
        return faker.letterify("???????Q@?");
    }

    public static String generatePasswordWithCyrillic() {
        faker = new Faker();
        return faker.letterify("??????СQ@?");
    }


}
