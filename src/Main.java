import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> num = Arrays.asList(12,34,67,22,4,22,5,7,77);
        ArrayList<Employee> empList = new ArrayList<>();

        Employee emp1 = new Employee("Shubham", 100000, 18);
        Employee emp2 = new Employee("Divya", 10000, 20);
        Employee emp3 = new Employee("Shubham", 100, 60);
        Employee emp4 = new Employee("Shubham", 1001, 30);
        Employee emp5 = new Employee("Shubham", 1000, 45);
        Employee emp6 = new Employee("Divya", 100,57);
        Employee emp7 = new Employee("Shubham", 100000, 80);

        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        empList.add(emp5);
        empList.add(emp6);
        empList.add(emp7);
//
        List<Employee> list =empList.stream().filter(e -> e.getName().equals("Shubham")
                && e.getSal()>1000).toList();


        System.out.println(list.size());
        list.forEach(System.out::println);

        Stream<String> s = Stream.of("apple", "orange", "grapes");
        int min = s.map(String::length).min(Integer::compareTo).get();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int output = numbers.stream()
                .filter(n -> n >2)
                .map(n -> n * 2)
                .reduce(0, Integer::sum);
        System.out.println("output: " + output);
//        System.out.println(string);
    }
}