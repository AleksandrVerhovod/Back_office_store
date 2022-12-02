package constants;

public class Urls {
    //API
    public static String URL_API = "https://junion-tech-server.onrender.com/";
    public static String URL_REG_USER = "users/register";
    public static String URL_LOGIN_USER = "users/login";
    public static String URL_SUPER_USER = "super";
    public static String URL_ALL_USERS = "super/users";
    public static String URL_VENDORS = "vendors";
    public static String URL_GET_USERS = "users/current";
    public static String URL_LOGOUT_USER = "users/logout";
    public static String URL_ALL_PRODUCTS = "products";
    public static String URL_CATEGORIES = "categories";
    public static String URL_VALID_NAME_PRODUCT = "products?name=%s";
    public static String URL_VALID_VENDOR_PRODUCT = "products?vendor=%s";
    public static String URL_VALID_MULTI_PARAMETERS_PRODUCT = "products?name=mounting&price=12000";
    public static String URL_VALID_RANGE_PRICE_PRODUCT = "products?price_min=500 ";
    public static String URL_PRODUCT = "products";

    public static String URL_VALID_VENDOR_NAME = "vendors?name=%s";
    public static String URL_DISCOUNT = "products/discount";
    public static String URL_DISCOUNT_SEARCH_BY_CATEGORY = "/products/discount?category=%s";
    public static String URL_DISCOUNT_SEARCH_BY_PRICE = "/products/discount?price=%s";
    public static String URL_DISCOUNT_SEARCH_BY_VENDOR = "/products/discount?vendor=%s";

    //UI
    public static String URL_BACK_OFFICE_OPEN = "https://junion-backoffice.vercel.app";
    public static String URL_BACK_OFFICE_MAIN = "https://junion-backoffice.vercel.app%s";
    public static String URL_BACK_OFFICE_LOGIN = "/login";
    public static String URL_BACK_OFFICE_REGISTER = "/register";
    public static String URL_BACK_OFFICE_PRODUCTS = "/products";



}
