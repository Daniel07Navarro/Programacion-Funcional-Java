package com.daniel.prueba;

import com.daniel.model.Person;
import com.daniel.model.Product;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        Person p1 = new Person(1, "Mito", LocalDate.of(1991, 1, 21));
        Person p2 = new Person(2, "Code", LocalDate.of(1990, 2, 21));
        Person p3 = new Person(3, "Jaime", LocalDate.of(1980, 6, 23));
        Person p4 = new Person(4, "Duke", LocalDate.of(2019, 5, 15));
        Person p5 = new Person(5, "James", LocalDate.of(2010, 1, 4));
        Person p6 = new Person(6, "Daila", LocalDate.of(2000, 5, 8));
        Person p7 = new Person(7, "Michael", LocalDate.of(2005, 7, 2));


        Product pr1 = new Product(1, "Ceviche", 15.0);
        Product pr2 = new Product(2, "Chilaquiles", 25.50);
        Product pr3 = new Product(3, "Bandeja Paisa", 35.50);
        Product pr4 = new Product(4, "Ceviche", 15.0);

        List<Person> personas = Arrays.asList(p1, p2, p3, p4, p5, p6,p7);
        List<Product> productos = Arrays.asList(pr1, pr2, pr3, pr4);


        Predicate<Person> verificar = x -> x.getName().startsWith("M");
        List<Person> listaFiltrada = personas.stream()
                .filter(verificar).collect(Collectors.toList());
        App.imprimiLista(listaFiltrada);


        //FILTER (predicate) EJEMPLOS:
        List<Person> nuevaLista = personas.stream()
                .filter(p -> App.getEdad(p.getBirthDate()) >= 18).collect(Collectors.toList());
        //App.imprimiLista(nuevaLista);

        //MAP (Function) EJEMPLOS:
        Function<Person, Integer> edadFuncion = p -> App.getEdad(p.getBirthDate());
        List<Integer> edades = personas.stream()
                .filter(person -> person.getName().startsWith("D")) //para la edad de la persona que empieza con D
                .map(edadFuncion) //retorna un entero por lo que la lista ahora es de enteros, estamos solamente recuperando la edad de la persona
                //.filter(x -> x>10)
                .collect(Collectors.toList()); //hacce una coleccion sobre el ultimo operador en este caso el map

        Function<Person, String> coderNombre = persona -> "PROGRAMADOR: " + persona.getName();
        List<String> nombres = personas.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        //App.imprimiLista(nombres);

        //Sorted (comparater) para poder ordernar EJEMPLO:
        Comparator<Person> nombreAscendente = (Person obj1, Person obj2) -> obj1.getName().compareTo(obj2.getName());
        Comparator<Person> nombreDescendente = (o1, o2) -> o2.getName().compareTo(o1.getName());
        List<Person> nombresV2 = personas.stream()
                .sorted(nombreDescendente)
                //.map(x -> x.getName())
                .collect(Collectors.toList());


        //MATCH (Predicate)
        Predicate<Person> empiezaConPredicado = p -> p.getName().startsWith("J");
        //any match no evalua todo el stream sino que termina en la coincidencia, es como que evalua que almenos uno cumpla
        boolean rpta1 = personas.stream()
                .anyMatch(empiezaConPredicado);
        //System.out.println(rpta1);

        //all match , verifica que todo el stream coincida
        boolean rpta2 = personas.stream().allMatch(empiezaConPredicado);
        //System.out.println(rpta2);

        //none match en este caso es como si ningun coincidiera pero en personas si hay alguno con la inicial J
        boolean rpt3 = personas.stream()
                .noneMatch(empiezaConPredicado);
        //System.out.println(rpt3);


        //LIMIT / SKIP
        int pageNumber = 0;
        int pageSize = 2;
        List<Person> filtradoList4 = personas.stream()
                //.skip(2)  en este caso la lista se salta los dos primeros
                .limit(2) //solo imprime un limite de dos registros
                .collect(Collectors.toList());
        //App.imprimiLista(filtradoList4);


        //COLLECTORS
        //GroupBy
        Map<String, List<Product>> collect1 = productos.stream()
                .filter(p -> p.getPrice() > 20)
                .collect(Collectors.groupingBy(Product::getName));
        //para apruparlo por nombre devuelve y también la lista de productos con ese nombre pero con un precio mayor a 20
        //System.out.println(collect1);

        //count para contar elementos de acuerdo a una cantidad de elementos que estoy agrupando
        Map<String, Long> collect2 = productos.stream()
                .collect(Collectors.groupingBy(Product::getName, Collectors.counting())); //
        //System.out.println(collect2);
        /*
        Map<Double, Long> collect3 = productos.stream()
                .filter(p-> p.getPrice()>20)
                .collect(Collectors.groupingBy(Product::getPrice, Collectors.counting()));
        System.out.println(collect3);

         */
    }

    public static int getEdad(LocalDate cumpleaños) {
        return Period.between(cumpleaños, LocalDate.now()).getYears();
    }



    public static void imprimiLista(List<?> lista) {
        lista.forEach(System.out::println);
    }
}
