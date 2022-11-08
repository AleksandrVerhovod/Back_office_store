package utils;

import com.github.javafaker.Faker;
import constants.Category;
import constants.Units;

import java.util.List;
import java.util.Random;

public class GenerateTestData {
    public static Faker faker;

    public static int getRandomIndex(int listSize) {
        Random random = new Random();
        return random.nextInt(listSize);
    }
    public static String generateEmail() {
        faker = new Faker();
        return faker.letterify("????????@test.com");
    }

    public static String generatePassword() {
        faker = new Faker();
        return faker.letterify("??????@1");
    }
    public static String generateName() {
        faker = new Faker();
        return faker.name().firstName();
    }

    public static int generatePrice() {
        faker = new Faker();
        return faker.number().randomDigitNotZero();
    }

    public static int generateQuantity() {
        faker = new Faker();
        return faker.number().numberBetween(0,999);
    }

    public static String getUnit() {
        List<String> getUnit = Units.getUnit();
        return getUnit.get(getRandomIndex(getUnit.size()));
    }

    public static String getCategory() {
        List<String> getCategory = Category.getCategory();
        return getCategory.get(getRandomIndex(getCategory.size()));
    }

    public static int generateDiscountPrice() {
        faker = new Faker();
        return faker.number().numberBetween(0,99);
    }

    public static int generateVendorCode() {
        faker = new Faker();
        return Integer.parseInt(faker.number().digits(3));
    }

    public static String generateStringVendorCode() {
        faker = new Faker();
        return faker.numerify("###");
    }


    public static String generateCategory() {
        faker = new Faker();
        return faker.pokemon().name();
    }

}
