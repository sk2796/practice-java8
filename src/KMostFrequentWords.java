import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KMostFrequentWords {

    //K Most Frequent Words
    public static void main(String[] args) {
        String s = "i like java and i like python and i like c";
        int k = 2;
        String[] split = s.split(" ");
        Map<String, Long> collect = Arrays.stream(split).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
        String [] result = collect.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);

        System.out.println(Arrays.toString(result));
    }
}
