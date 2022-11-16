package com.daniel.prueba;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PruebaPredicate {

    public static void main(String[] args) {
            Predicate<Integer> numeroPositivos = x -> x>0;
            Predicate<Integer> numerosPares = x -> x%2==0;
            List<Integer> numeros = List.of(1,-9,5,6,-5,84,5,-69,-48,15,16,2);
            PruebaPredicate prueba = new PruebaPredicate();
            prueba.filtrar(numeros,numeroPositivos,numerosPares).forEach(System.out::println);
    }

    public List<Integer> filtrar(List<Integer> lista, Predicate<Integer> predicado,Predicate<Integer> predicado2) {
        List<Integer> resultado = new ArrayList<>();
        for(int numero: lista){
            if(predicado.and(predicado2).test(numero)){
                resultado.add(numero);
            }
        }
        return resultado;
    }

}
