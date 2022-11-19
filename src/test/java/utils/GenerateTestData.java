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
    public static String generateEmail() {
        faker = new Faker();
        return faker.letterify("????????@test.com");
    }

    public static String generateUPPERCaseEmail() {
        faker = new Faker();
        return faker.letterify("TEST????????@test.com");
    }

    public static String generateWithSpacesEmail() {
        faker = new Faker();
        return faker.letterify(" ????????@test.com ");
    }
    public static String generateMinEmail() {
        faker = new Faker();
        return faker.letterify("???@test.com");
    }

    public static String generateMinPlus1Email() {
        faker = new Faker();
        return faker.letterify("????@test.com");
    }
    public static String generateMaxEmail() {
        faker = new Faker();
        return faker.letterify("??????????????????????????????????????????????????@test.com");
    }

    public static String generateMaxMinus1Email() {
        faker = new Faker();
        return faker.letterify("?????????????????????????????????????????????????@test.com");
    }
    public static String generatePassword() {
        faker = new Faker();
        return faker.letterify("??????Q@#&/!-.%$1");
    }

    public static String generateMinPassword() {
        faker = new Faker();
        return faker.letterify("???Q@1");
    }

    public static String generateMinPlus1Password() {
        faker = new Faker();
        return faker.letterify("????Q@1");
    }

    public static String generateMaxPassword() {
        faker = new Faker();
        return faker.letterify("?????????????????Q@1");
    }

    public static String generateMaxMinus1Password() {
        faker = new Faker();
        return faker.letterify("????????????????Q@1");
    }


    public static String generateMax1Password() {
        faker = new Faker();
        return faker.letterify("??????????????????Q@1");
    }

    public static String generateMin1Password() {
        faker = new Faker();
        return faker.letterify("Q@1??");
    }

    public static String generateLowerCasePassword() {
        faker = new Faker();
        return faker.letterify("string@1");
    }

    public static String generateUpperCasePassword() {
        faker = new Faker();
        return faker.letterify("STRING@1");
    }

    public static String generateWithoutSpecCharPassword() {
        faker = new Faker();
        return faker.letterify("???????Q1");
    }

    public static String generateWithoutNumberPassword() {
        faker = new Faker();
        return faker.letterify("???????Q@?");
    }

    public static String generateWithCyrillicPassword() {
        faker = new Faker();
        return faker.letterify("??????СQ@?");
    }


    public static String generateName() {
        faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateFullName() {
        faker = new Faker();
        return faker.name().fullName();
    }



    public static String generateMinFullName() {
        faker = new Faker();
        return faker.letterify("???");
    }

    public static String generateMinMinus1FullName() {
        faker = new Faker();
        return faker.letterify("??");
    }
    public static String generateMinPlus1FullName() {
        faker = new Faker();
        return faker.letterify("???");
    }
    public static String generateWithoutSpaceMaxFullName() {
        faker = new Faker();
        return faker.letterify("???????????????????????????????????????????????????????????");
    }
    public static String generateMaxPlus1FullName() {
        faker = new Faker();
        return faker.letterify("???????????????????????????????????????????????????????????");
    }

    public static String generateMaxMinus1FullName() {
        faker = new Faker();
        return faker.letterify("???????????????????????????????????????????????????????????");
    }

    public static String generateWithOneSpaceFullName() {
        faker = new Faker();
        return faker.letterify("????? ???????????");
    }

    public static String generateWithTwoSpacesFullName() {
        faker = new Faker();
        return faker.letterify("???????????????? ????????????? ???????????");
    }
    public static String generateBeginEndSpacesFullName() {
        faker = new Faker();
        return faker.letterify(" ?????????? ????????????? ");
    }
    public static String generateWithTreeSpacesFullName() {
        faker = new Faker();
        return faker.letterify("????? ?????????? ????????????? ???????????");
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
