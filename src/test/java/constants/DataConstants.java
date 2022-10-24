package constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DataConstants {
    public static List<String> PRODUCTS () {
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"bread", "doughnut", "bicycle", "dress", "Bike Red");
        return  names.stream().collect(Collectors.toList());
    }
    public static List<String> QUERY_PRODUCTS () {
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"bread");
        return  names.stream().collect(Collectors.toList());
    }
}
