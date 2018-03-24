package net.albertoi.lambda.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        consumerAccept();
        consumerAcceptMultipleBody();
        consumerInAFunction();
        biConsumerAccept();
    }

    /**
     * Accepts one parameter and no return anything
     */
    private static void consumerAccept() {
        Consumer<String> consumer = (x) -> System.out.println(x.toLowerCase());
        // Consumer accept performs operation on the given argument.
        consumer.accept("Hello World!!");
    }

    /**
     * Accepts one parameter, no return, and multiples sentences in body
     */
    private static void consumerAcceptMultipleBody() {
        int x = 99;
        Consumer<Integer> consumer = (y) -> {
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        };
        consumer.accept(98);
    }

    /**
     * Consumer as a function parameter
     */
    private static void consumerInAFunction() {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 30000),
                new Employee("Mark", 40000)
        );
        acceptAllEmployee(employees, consumer1 -> System.out.println(consumer1.name + ": " + consumer1.salary));
        acceptAllEmployee(employees, consumer2 -> consumer2.salary *= 1.1);
        acceptAllEmployee(employees, consumer3 -> System.out.println(consumer3.name + ": " + consumer3.salary));
    }

    private static void acceptAllEmployee(List<Employee> employee, Consumer<Employee> consumer) {
        for (Employee e : employee) {
            consumer.accept(e);
        }
    }



    /**
     * BiConsumer, accepts 2 parameters and no return
     */
    private static void biConsumerAccept() {
        BiConsumer<String, Integer> bc = (String key, Integer value) -> System.out.printf("Key: %s, value: %s%n", key, value);
        // Consumer accept performs operation on the given arguments.
        bc.accept("Hi", 2018);
    }
}


class Employee {
    public String name;
    public double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
