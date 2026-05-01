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
//                hmap.put(i, hmap.get(i));
//            } else hmap.put(arr[i] , 1);
//        }
//        System.out.println(hmap);

       // reduce to sum
        Optional<Integer> reduce = Arrays.stream(arr1).boxed().reduce(Integer::sum);
        System.out.println("reduce  "+reduce.get());

        List<String> stringList = Arrays.asList("Shubham", "AKA", "Pooja", "Divya", "7gshsj", "3akshsahksn");
        String str = " ShubhamKumarytyutyguy";

        Map<Character, Long> collect9 = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<Character, Long> characterLongEntry = collect9.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();
        System.out.println("Most repeated char  "+characterLongEntry);

        //Second non - repeating
        Map<Character, Long> collect8 = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect8);
        Character c1 = collect8.entrySet().stream().filter(e -> e.getValue() == 1)
                .map(en -> en.getKey()).skip(1).findFirst().get();
        System.out.println("Second non repeating char  "+c1);

        //Frequecy
        Map<Character, Long> collect7 = str.chars().mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency of char  "+collect7);


        //partitioning
        Map<Boolean, List<Integer>> collect6 =
                Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("Partitioning  "+collect6);

        //rev each word
        String c = stringList.stream().map(s -> new StringBuffer(s).reverse()).collect(Collectors.joining(","));
        System.out.println("Reverse each word  "+c);

        //common between two arrays
        List<Integer> collect5 = Arrays.stream(arr).boxed().filter(num::contains).toList();
        System.out.println("Common between two arrays  "+collect5);

        //2nd larget in int arr
        int asInt = Arrays.stream(arr1).sorted().skip(arr1.length - 2).findFirst().getAsInt();
        Integer i1 = num.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("2nd largest in int arr  "+asInt);


        //strnum
        Integer collect2 = Stream.of(strnum.split("")).mapToInt(Integer::parseInt).sum();
        int max1 = num.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
        int max = num.stream().collect(Collectors.summingInt(Integer::intValue));
        Integer collect3 = Stream.of(String.valueOf(z).split("")).mapToInt(Integer::parseInt).sum();
        System.out.println("Sum of digits in strnum  "+collect2);
        System.out.println("Max in num list  "+max1);
        System.out.println("Sum of num list  "+max);
        System.out.println("Sum of digits in z  "+collect3);

        //toUppercase
        List<String> s1 = Stream.of(str.split("")).map(String::toUpperCase).toList();
        List<String> collect1 = stringList.stream().map(String::toUpperCase).toList();
        System.out.println(s1);
        System.out.println(collect1);
        //Average
        double asDouble = IntStream.of(arr1).average().getAsDouble();
        System.out.println("Average of arr1  "+asDouble);

        //Sort str list on order of length
        List<String> sort = stringList.stream().sorted(Comparator.comparing(String::length)).toList();
        System.out.println("Sort str list on order of length  "+sort);

        //Max and Min - 3 elements
        List<Integer> min = num.stream().distinct().sorted().limit(3).toList();
        List<Integer> max2 = num.stream().distinct().sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println(max);
        System.out.println(min);

        //fibbonaci

        //uncommon between two arrays
        List<Integer> collect = Arrays.stream(arr).boxed().filter(x -> !num.contains(x)).toList();
        System.out.println("Uncommon between two arrays  "+collect);

        //Union
        int[] array1 = IntStream.concat(Arrays.stream(arr), Arrays.stream(arr1)).distinct().sorted().toArray();
        long count = IntStream.concat(Arrays.stream(arr), Arrays.stream(arr1)).distinct().count();
        System.out.println("Union  "+Arrays.toString(array1));
        System.out.println("Count of union  "+count);


        //Intersection
        List<Integer> intersection = num.stream().distinct().filter(x -> Arrays.stream(arr).anyMatch(k -> k==x)).toList();
        System.out.println("Intersection  "+intersection);

        //Distinct
        List<Integer> distinct = num.stream().distinct().toList();
        System.out.println("Distinct  "+distinct);

        //Find Duplicates
        HashSet<Integer> set = new HashSet<>();
        List<Integer> dup = num.stream().filter(x -> !set.add(x)).toList();
        System.out.println("Duplicates  "+dup);
        System.out.println("Duplicates using frequency  "+num.stream().filter(x -> Collections.frequency(num, x) > 1).distinct().toList());

        //String start with number
        List<String> list = stringList.stream().filter(s -> Character.isDigit(s.charAt(0))).toList();
        System.out.println("String start with number  "+list);

        //sum of natural no
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Sum of natural no  "+sum);

        //Age of person in years
        LocalDateTime today = LocalDateTime.now();
        System.out.println("Today's date  "+today);
        LocalDate dob = LocalDate.of(1995, 07, 02);
        long between = ChronoUnit.YEARS.between(dob, today);
        System.out.println( "Age of person in years  "+between);
        System.out.println("Age of person in years using period  "+ChronoUnit.YEARS.between(dob, today));

        //last element of an array
        String s = stringList.stream().skip(stringList.size() - 1).findFirst().get();
        System.out.println("Last element of an array  "+s);

        //Reverse order
        int[] array = IntStream.rangeClosed(1, arr.length).map(i -> arr[arr.length - i]).toArray();
        System.out.println(" 25  "+Arrays.toString(array));

        //Pallindrome //Not working
        String st = "aba";
        boolean b = IntStream.rangeClosed(1, st.length() / 2).allMatch(i -> st.charAt(1) == st.charAt(st.length() - 1));
        System.out.println("Pallindrome");
        System.out.println(b);

    }
}
