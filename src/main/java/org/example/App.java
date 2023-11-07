package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        int intValue = 23;
//        Function<Integer, String> intToString = num -> String.valueOf(num);
//        Function<Integer, Integer> doubleInteger = num -> num * 2;
//        String stringValue = intToString.apply(intValue);
//        Predicate<Integer> isOdd = x -> x % 2 == 1;
//        int doubled = doubleInteger.apply(intValue);
//        System.out.println(doubled);
//        System.out.println(stringValue);
//        System.out.println(isOdd.test(intValue));
//        System.out.println(isOdd.test(doubled));
//        Consumer<String> consumer = string -> System.out.println(string);
//        consumer.accept("Helloo");
//        Supplier<Double> randomDouble = () -> Math.random();
//        System.out.println(randomDouble.get());
//        BinaryOperator<Integer> subtract = (x, y) -> x - y;
//        System.out.println(subtract.apply(6, 2));
//        StringFunctionalInterface myInterface = s -> s + "???";
//        System.out.println(myInterface.applyFunction("Is this a question"));
//        List<List<String>> listOfLists = new ArrayList<>();
//        listOfLists.add(List.of("a", "b", "c"));
//        listOfLists.add(List.of("d", "e", "f"));
//        listOfLists.add(List.of("1", "2", "3"));

        Predicate<Integer> atLeastContainsOneEvenNumber = num -> num % 2 == 0;
        Predicate<Integer> everythingIsDivisibleBy3 = num -> num % 3 == 0;
        List<Integer> numbers = List.of(1, 12, 5, 3, 4, 7, 8, 9);
        boolean containsOneEvenNumber = numbers
                .stream()
                .anyMatch(atLeastContainsOneEvenNumber);
        System.out.println(containsOneEvenNumber);
        boolean everythingDivisibleBy3 = numbers
                .stream()
                .allMatch(everythingIsDivisibleBy3);
        System.out.println(everythingDivisibleBy3);
        boolean noneIsDivisibleBy3 = numbers
                .stream()
                .noneMatch(everythingIsDivisibleBy3);
        System.out.println(noneIsDivisibleBy3);

        Optional<Integer> numberDivisibleBy3 = numbers
                .stream()
                .filter(App::isOdd)
                .findAny();

        numberDivisibleBy3.ifPresent(x -> System.out.println(x));

        List<String> strings = List.of("Hello", "this", "is", "list");
        String result = String.join("!", strings);
        System.out.println(result);

        List<Person> people = List.of(new Person("Bob", 12),
                new Person("Alice", 22),
                new Person("Michael", 23),
                new Person("John", 22),
                new Person("Martin", 52),
                new Person("Maria", 12),
                new Person("Tom", 57),
                new Person("Julia", 69));
        Map<Integer, List<Person>> groupedByAge = people
                .stream()
                .collect(groupingBy(Person::getAge));
        System.out.println(groupedByAge);

        Map<Integer, List<String>> namesGroupedByAge = people
                .stream()
                .collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));
        System.out.println(namesGroupedByAge);

        List<String> names = people.stream()
//                .filter(person -> person.getName().length() > 3)
                .map(App::getName)
                .toList();
        System.out.println(names);

        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(upperCaseNames);
    }

    public String intToString(Integer integer) {
        return String.valueOf(integer);
    }

    public Integer doubleInteger(Integer integer) {
        return integer * 2;
    }

    public static boolean isOdd(Integer integer) {
        return integer % 2 == 1;
    }

    public static String getName(Person person) {
        if (person.getName().charAt(0) == 'M') {
            return person.getName();
        }
        return "M" + person.getName();
    }

    public void printToConsole(String string) {
        System.out.println(string);
    }
}
