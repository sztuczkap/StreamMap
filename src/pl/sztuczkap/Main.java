package pl.sztuczkap;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

/*        List<User> users = new ArrayList<>();
        users.add(new User(1, "Jan", 30, List.of("Sport", "Motoryzacja")));
        users.add(new User(2, "Ola", 20, List.of("Film", "Podróże")));
        users.add(new User(3, "Adam", 25, List.of("Informatyka")));
        users.add(new User(4, "Jan", 50, List.of("Malarstwo")));*/

/*        // z list tworzymy mape jako klucz to id a wartosc imie
        Map<Integer, String> collect =  users
                .stream()
                .collect(Collectors.toMap(User::getId, User::getName));*/

/*        // mapa: id jako klucz i obiekt jako wartość mapy
        Map<Integer, User> collect = users
                .stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));  // value: user -> user*/

/*        // mapa: klucz imie; wartośc: wiek użytkownika
        Map<String, Integer> collect = users.stream()
                .collect(Collectors.toMap( // Exception: Duplicate key Jan (przed przeciążeniem)
                        User::getName,
                        User::getAge,
                        (oldValue, newValue) -> newValue)); // przeciążenie metody toMap

        collect.forEach((k, v) -> System.out.println("Key: " + k + " value: " + v));*/

/*        // mapa imion z przypisanymi zainteresowaniami
        // w przypadku tych samych kluczy połączymy je w pojedyncza liste
        Map<String, List<String>> collect = users.stream()
                .collect(Collectors.toMap(
                        User::getName,
                        User::getHobbies,
                        (oldValue, newValue) ->
                                Stream.concat(oldValue.stream(), newValue.stream())
                                        .collect(Collectors.toList())
                ));
        // polaczone zainteresowania  usytkownika JAN
        collect.forEach((k, v) -> System.out.println("Key: " + k + " value: " + v));*/


/*        // 4 argument który ma jedna z przeciazonych wersji toMap
        // podajemy referencje do konstruktora i wymuszamy jaka struktura zostanie stworzona
        // i w tym przypadku tworzymy TreeMap
        TreeMap<String, List<String>> collect = users.stream()
                .collect(Collectors.toMap(
                        User::getName,
                        User::getHobbies,
                        (oldValue, newValue) ->
                                Stream.concat(oldValue.stream(), newValue.stream())
                                        .collect(Collectors.toList()),
                        TreeMap::new
                ));
        // polaczone zainteresowania  usytkownika JAN  + posortowane klucze
        collect.forEach((k, v) -> System.out.println("Key: " + k + " value: " + v));*/

        // ====================================
        // ============ GRUPOWANIE ============
        // ====================================

/*        // tworzymy mapę z kluczem String i listą userów
        // w metodzie collect wywołamy Collectors groupingBy, gdzie podamy po czym będzie grupowany
        Map<String, List<User>> collect = users
                .stream()
                .collect(Collectors.groupingBy(User::getName));

        // wypisujemy na konsoli jak zostali pogrupowani uzytkownicy
        collect.forEach((k, v) -> System.out.println("Klucz: " + k + " wartość: " + v));*/

/*        // podobną funkcją jest partitioningBy (dzieli ona elementy strumienia na dwie mozliwe wartosci)
        // tworzymy mape gdzie klucz bedzie typu boolean, a wartosc to lista uzytkownikow
        // po d kluczem true będa uzytkownicy spelniajacy warunek przekazany do metody partitioningBy
        // a pod false Ci którzy tego warunku nie spałeniaja
        // uzytkownikow podzileimy po wieku
        Map<Boolean, List<User>> collect = users
                .stream()
                .collect(Collectors.partitioningBy(user -> user.getAge() > 25));

        collect.forEach((k, v) -> System.out.println("Klucz: " + k + " wartość: " + v));*/

/*        // przeciazona wersja metody grouppingBy posiada także 2 argument
        // w którym możemy definiować jak zostają zebrane wartości zgrupowanych elementów (Collectory strumieniowe)
        // zamiast listy wartości chcemy otrzymać zestaw (Set)
        Map<String, Set<User>> collect = users
                .stream()
                .collect(Collectors.groupingBy(User::getName, Collectors.toSet()));

        collect.forEach((k, v) -> System.out.println("Klucz: " + k + " wartość " + v));*/

/*        // istnieje kilka kolektorów do zamiany pogrupowanych elementów na liczby:
        Map<String, Long> collect = users
                .stream()
                .collect((Collectors.groupingBy(User::getName, Collectors.counting())));

        collect.forEach((k, v) -> System.out.println("Klucz: " + k + " wartość: " + v));*/

/*        // sumujemy wiek pogrupowanych użytkowników
        Map<String, Integer> collect = users
                .stream()
                .collect((Collectors.groupingBy(User::getName, Collectors.summingInt(User::getAge))));

        collect.forEach((k, v) -> System.out.println("Klucz: " + k + " wartość: " + v));*/

/*        // metody maxBy i minBy  (przedstawia najmłodszą osobę z grupy)
        Map<String, Optional<User>> collect = users
                .stream()
                .collect(Collectors.groupingBy(User::getName,
                        Collectors.minBy(Comparator.comparing(User::getAge))));

        collect.forEach((k, v) -> System.out.println("Klucz: " + k + " wartość: " + v.get()));*/

/*        // funkcja mapping (mapujemy elementy strumienia)
        // - potrzebuje dodatkowego collectora do zebrania wyników
        // tworzymy mapę imion gdzie wartosciami będzie lista ich wieku
        Map<String, List<Integer>> collect = users
                .stream()
                .collect(Collectors.groupingBy(User::getName,
                        Collectors.mapping(User::getAge, Collectors.toList())));

        collect.forEach((k, v) -> System.out.println("Klucz: " + k + " wartość: " + v));*/

/*        //tworzymy mapę imion gdzie wartoscia będzie obiekt intSummryStatistic
        Map<String, IntSummaryStatistics> collect = users
                .stream()
                .collect(Collectors.groupingBy(User::getName,
                        Collectors.summarizingInt(User::getAge)));

        collect.forEach((k, v) -> System.out.println("Klucz: " + k + " wartość: " + v.getAverage()));*/

        // ====================================
        // =========== Metoda reduce ==========  // redukcja strumienia
        // ====================================
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Jan", 30, BigDecimal.valueOf(3000.0), List.of("Sport", "Motoryzacja")));
        users.add(new User(2, "Ola", 20, BigDecimal.valueOf(2800.99), List.of("Film", "Podróże")));
        users.add(new User(3, "Adam", 25, BigDecimal.valueOf(6000.5), List.of("Informatyka")));
        users.add(new User(4, "Jan", 50, BigDecimal.valueOf(9000.0), List.of("Malarstwo")));

/*        Optional<BigDecimal> reduce = users
                .stream()
                .map(User::getSalary)
                .reduce(BigDecimal::add); // (salar1, salar2) -> salar1.add(salar2)

        System.out.println(reduce.get()); // drukujemy zsumowane pensje*/

        // wykorzystujemy 2-argumentowa wersję funkcji reduce
        // gdzie jako pierwszy argument podamy wartosc do rozpoczecia obliczen
        // np mamy buzdet i chcemy uzyskac zysk po zaplaceniu pensji uzytkownikom
        BigDecimal reduce = users
                .stream()
                .map(User::getSalary)
                .reduce(BigDecimal.valueOf(40000.0), (salary1, salary2) -> salary1.subtract(salary2));

        System.out.println(reduce);

    }
}
