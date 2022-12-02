package utils;

import com.github.javafaker.Faker;

public class GenerateProduct {
    public static Faker faker;

    public static String generateProductName() {
        faker = new Faker();
        return faker.commerce().productName();
    }

    public static String generateCategory() {
        faker = new Faker();
        return faker.commerce().material();
    }

    public static String generatePrice() {
        faker = new Faker();
        return faker.commerce().price();
    }

    public static String generateQuantity() {
        faker = new Faker();
        return faker.commerce().price();
    }

    public static String generateVendor() {
        faker = new Faker();
        return faker.commerce().department();
    }

    public static String generateVendorsCode() {
        faker = new Faker();
        return faker.number().digits(3);
    }
}
