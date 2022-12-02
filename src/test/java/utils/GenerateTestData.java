package utils;

import com.github.javafaker.Faker;
import constants.api.Category;
import constants.api.Units;

import java.util.List;
import java.util.Random;

public class GenerateTestData {
    public static Faker faker;

    public static int getRandomIndex(int listSize) {
        Random random = new Random();
        return random.nextInt(listSize);
    }

    // ---------------EMAIL----------------------------
    public static String generateEmail() {
        faker = new Faker();
        return faker.letterify("????????@test.ru");
    }


    // --------------------------PASSWORD-----------------------------
    public static String generatePassword() {
        faker = new Faker();
        return faker.letterify("??????Q#1");
    }


    public static String generateName() {
        faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateFullName() {
        faker = new Faker();
        return faker.name().lastName();
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

    public static String generateVendorName() {
        faker = new Faker();
        return faker.name().lastName();
    }

    public static int generateVendorRegCode() {
        faker = new Faker();
        return Integer.parseInt(faker.number().digits(8));
    }

    public static String generateVendorAddress() {
        faker = new Faker();
        return faker.address().fullAddress();
    }

    public static String generateCategory() {
        faker = new Faker();
        return faker.pokemon().name();
    }

}
