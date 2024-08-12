import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class PracticeJava8 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int[] arr = {12,34,67,22,4,5,22,7,77,100};
        int[] arr1 = {1, 2,74, 3, 4, 5};
        List<Integer> num = Arrays.asList(12,34,65,22,4,22,5,7,77,67);
        List<Integer> collect4 = Arrays.stream(arr).boxed().toList();
        String strnum = "2784979";
        int target = 27;
        int z = 64328748;
//        frequency()
//        System.out.println(collect10);

        //target - 27  //12,34,65,22,4,22,5,7,77,67
//        Map<Integer, Integer> hmap = new HashMap<>();
//        for(int i =0; i<arr.length; i++) {
//            int diff = target - arr[i];
//            if(hmap.containsKey(diff)) {
//                hmap.put(i, hmap.get(i)+1);
//            } else hmap.put(i , 1);
//        }
//        System.out.println(hmap);

       // reduce to sum
        Optional<Integer> reduce = Arrays.stream(arr1).boxed().reduce(Integer::sum);
//        System.out.println(reduce.get());

        List<String> stringList = Arrays.asList("Shubham", "AKA", "Pooja", "Divya", "7gshsj", "3akshsahksn");
        String str = " ShubhamKumarytyutyguy";

        Map<Character, Long> collect9 = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<Character, Long> characterLongEntry = collect9.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue)).get();
        System.out.println(characterLongEntry.getKey() + "  "+ characterLongEntry.getValue());

        //Second non - repeating
        Map<Character, Long> collect8 = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        Character c1 = collect8.entrySet().stream().filter(e -> e.getValue() == 1)
                .map(en -> en.getKey()).skip(1).findFirst().get();
//        System.out.println(collect8);
//        System.out.println(c1);

        //Frequecy
        Map<Character, Long> collect7 = str.chars().mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect7);


        //partitioning
        Map<Boolean, List<Integer>> collect6 =
                Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(collect6.get(true));

        //rev each word
        String c = stringList.stream().map(s -> new StringBuffer(s).reverse()).collect(Collectors.joining(","));
        System.out.println(c);

        //common between two arrays
        List<Integer> collect5 = Arrays.stream(arr).boxed().filter(num::contains).toList();
        System.out.println(collect5);

        //2nd larget in int arr
        int asInt = Arrays.stream(arr1).sorted().skip(arr1.length - 2).findFirst().getAsInt();
        Integer i1 = num.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
//        System.out.println(asInt);


        //strnum
        Integer collect2 = Stream.of(strnum.split("")).mapToInt(Integer::parseInt).sum();
        int max1 = num.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
        Integer collect3 = Stream.of(String.valueOf(z).split("")).mapToInt(Integer::parseInt).sum();
//        System.out.println(max1);
        System.out.println(collect2);

        //toUppercase
        List<String> s1 = Stream.of(str.split("")).map(String::toUpperCase).toList();
        List<String> collect1 = stringList.stream().map(String::toUpperCase).toList();
        System.out.println(s1);
        System.out.println(collect1);
        //Average
        double asDouble = IntStream.of(arr1).average().getAsDouble();
//        System.out.println(asDouble);

        //Sort str list on order of length
        List<String> sort = stringList.stream().sorted(Comparator.comparing(String::length)).toList();
        System.out.println(sort);

        //Max and Min - 3 elements
        List<Integer> max = num.stream().distinct().sorted().limit(3).toList();
        List<Integer> min = num.stream().distinct().sorted(Comparator.reverseOrder()).limit(3).toList();
//        System.out.println(max);
//        System.out.println(min);

        //fibbonaci

        //uncommon
        List<Integer> collect = num.stream().filter(x -> Arrays.stream(arr).noneMatch(k -> x == k)).toList();
//        System.out.println(collect);

        //Union
        int[] array1 = IntStream.concat(Arrays.stream(arr), Arrays.stream(arr1)).distinct().sorted().toArray();
        long count = IntStream.concat(Arrays.stream(arr), Arrays.stream(arr1)).distinct().sorted().count();
//        System.out.println(Arrays.toString(array1));
//        System.out.println(count);


        //Intersection
        List<Integer> intersection = num.stream().distinct().filter(x -> Arrays.stream(arr).anyMatch(k -> k==x)).toList();
//        System.out.println(intersection);

        //Distinct
        List<Integer> distinct = num.stream().distinct().toList();
//        System.out.println(distinct);

        //Find Duplicates
        HashSet<Integer> set = new HashSet<>();
        List<Integer> dup = num.stream().filter(x -> !set.add(x)).toList();
//        System.out.println(dup);
//        System.out.println(set);

        //String start with number
        List<String> list = stringList.stream().filter(s -> Character.isDigit(s.charAt(0))).toList();
//        System.out.println(list);

        //sum of natural no
        int sum = IntStream.rangeClosed(1, 10).sum();
//        System.out.println(sum);

        //Age of person in years
        LocalDateTime today = LocalDateTime.now();
//        System.out.println(today);
        LocalDate dob = LocalDate.of(1995, 07, 02);
        long between = ChronoUnit.YEARS.between(dob, today);
//        System.out.println(dob);
//        System.out.println(between);

        //last element of an array
        String s = stringList.stream().skip(stringList.size() - 1).findFirst().get();
//        System.out.println(s);

        //Reverse order
        int[] array = IntStream.rangeClosed(1, arr.length).map(i -> arr[arr.length - i]).toArray();

        //Pallindrome
        boolean b = IntStream.rangeClosed(1, str.length() / 2).noneMatch(i -> str.charAt(1) == str.charAt(str.length() - 1));

    }
}
