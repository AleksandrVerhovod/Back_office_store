package constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DataConstants {
    public static List<String> PRODUCTS () {
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"meat", "carrot", "bicycle", "mounting byke", "cellphone Iphone13", "cellphone Xiaomi xxx", "ball", "gym ball", "gym bar", "gym bar cross", "boxes", "boxes small", "boxes medium", "coffee Nescafe", "teapot", "Tea", "green tea ");
        return  names.stream().collect(Collectors.toList());
    }


    public static String USER () {
        return "AQATest";
    }

    public static List<String> ID_PRODUCT () {
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"bread");
        return  names.stream().collect(Collectors.toList());
    }
}
