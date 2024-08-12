import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Employee emp1 = new Employee("Shubham", 100000, 18);
        Employee emp2 = new Employee("Divya", 10000, 20);
        Employee emp3 = new Employee("Shubham", 100, 60);
        Employee emp4 = new Employee("Shubham", 1001, 30);
        Employee emp5 = new Employee("Shubham", 1000, 45);
        Employee emp6 = new Employee("Divya", 100,57);
        Employee emp7 = new Employee("Shubham", 100000, 80);

        map.put(emp1.getName(), emp1.getAge());
        map.put(emp2.getName(), emp2.getAge());
        map.put(emp3.getName(), emp3.getAge());
        map.put(emp4.getName(), emp4.getAge());
        map.put(emp5.getName(), emp5.getAge());
        map.put(emp6.getName(), emp6.getAge());

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() +"  "+ entry.getValue());
        }

        System.out.println(emp1.hashCode());


//        System.out.println(map.get(emp1.getName()));

//        empList.add(emp1);
//        empList.add(emp2);
//        empList.add(emp3);
//        empList.add(emp4);
//        empList.add(emp5);
//        empList.add(emp6);
//        empList.add(emp7);


    }
}
