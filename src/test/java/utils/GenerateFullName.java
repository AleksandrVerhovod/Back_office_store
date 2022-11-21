package utils;

import com.github.javafaker.Faker;

public class GenerateFullName {
    public static Faker faker;

    public static String generateFullName() {
        faker = new Faker();
        return faker.name().lastName();
    }

    public static String generateMinFullName() {
        faker = new Faker();
        return faker.letterify("???");
    }

    public static String generateMinPlus1FullName() {
        faker = new Faker();
        return faker.letterify("B???");
    }

    public static String generateWithoutSpaceMaxFullName() {
        faker = new Faker();
        return faker.letterify("???????????????????????????????????????????????????????????");
    }

    public static String generateWithTwoSpacesFullName() {
        faker = new Faker();
        return faker.letterify("????????? ?????????????????????? ??????????");
    }

    public static String generateMinMinus1FullName() {
        faker = new Faker();
        return faker.letterify("??");
    }

    public static String generateWithOneSpaceFullName() {
        faker = new Faker();
        return faker.letterify("????? ???????????");
    }

    public static String generateWithDotFullName() {
        faker = new Faker();
        return faker.letterify("Mr. ?????????????????????? ??????????");
    }

    public static String generateBeginEndSpacesFullName() {
        faker = new Faker();
        return faker.letterify(" ?????????? ????????????? ");
    }

    public static String generateWithDashFullName() {
        faker = new Faker();
        return faker.letterify("?????-??????????");
    }


    public static String generateWithTreeSpacesFullName() {
        faker = new Faker();
        return faker.letterify("????? ?????????? ????????????? ???????????");
    }

    public static String generateMaxPlus1FullName() {
        faker = new Faker();
        return faker.letterify("???????????????????????????????????????????????????????????");
    }

    public static String generateMaxMinus1FullName() {
        faker = new Faker();
        return faker.letterify("???????????????????????????????????????????????????????????");
    }


}
