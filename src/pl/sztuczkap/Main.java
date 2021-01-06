package pl.sztuczkap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User(1, "Jan", 30, List.of("Sport", "Motoryzacja")));
        users.add(new User(2, "Ola", 20, List.of("Film", "Podróże")));
        users.add(new User(3, "Adam", 25, List.of("Informatyka")));
        users.add(new User(4, "Jan", 50, List.of("Malarstwo")));

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


        // 4 argument który ma jedna z przeciazonych wersji toMap
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
        collect.forEach((k, v) -> System.out.println("Key: " + k + " value: " + v));

    }
}
