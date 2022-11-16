package com.daniel.prueba;

import java.util.List;
import java.util.stream.Collectors;

public class PruebaStream {

    public static void main(String[] args) {
        PruebaStream app = new PruebaStream();
        (app.nuevaLista(List.of(1,5,8,6,10,15,12,18,6))).forEach(System.out::println);
    }

    public List<Integer> nuevaLista(List<Integer> numeros){
        return numeros.stream().filter(x -> x>8).collect(Collectors.toList());
    }

}
