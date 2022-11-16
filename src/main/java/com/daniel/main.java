package com.daniel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class main {

    public static void main(String[] args) {
        //STREAMS //LAMBAD
        List<String> ciudades = new ArrayList<>();
        ciudades.add("LIMA");
        ciudades.add("TOKYO");
        ciudades.add("CAJAMARCA");
        ciudades.add("BOGOTA");
        ciudades.add("CIUDAD DE MEXICO");
        /*
        FOR BASICOS
        for(String ciudad: ciudades){
            System.out.println(ciudad);
        }
        ciudades.forEach(x -> System.out.println(x));

        // PARA IMPRIMIR USANDO LAMBDA
        ciudades.forEach(x -> System.out.println(x));
        PARA PASARLE UNA FUNCION ESTATICA METODOS POR REFERENCIA
        System.out.println("\tFUNCION ESTATICA");
        ciudades.forEach(main::mostrarCiudad);

        //STREAM PARALELO - USANDO PATRON DE DISEÑO Pipeline
        System.out.println("STREAM PARALELO");
        ciudades.stream().parallel().forEach(System.out::println);


        //por ejemplo si queremos hacer un filtro pasando por referencia:
        ciudades.stream().
                filter(main::filtrarCiudad).
                forEach(x -> System.out.println(x));

         filtro normal:
         ciudades.stream()
                .filter(x -> x.startsWith("C"))
                .forEach(System.out::println);
         */


        //FILTRO NORMAL PERO UN FILTER NUNCA PUEDE SER UN METODO TERMINAL
        ciudades.stream()
                .filter(x -> x.startsWith("C"))
                .filter(x -> x.contains("A"))
                .forEach(System.out::println);

        //PARA PODER GUARDAR LOS DATOS FILTRADOS EN ALGUNA LISTA:
        List<String> datosFiltrados = ciudades.stream().
                filter(main::filtrarCiudad).
                filter(x -> x.contains("A")).
                collect(Collectors.toList());
        datosFiltrados.forEach(System.out::println);


    }

    public static boolean filtrarCiudad(String ciudad) {
        return ciudad.startsWith("C");
    }

    public static void mostrarCiudad(String ciudad) {
        System.out.println(ciudad);
    }


}
