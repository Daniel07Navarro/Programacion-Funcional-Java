package com.daniel.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(6);
        lista.add(6);
        lista.add(9);
        lista.add(12);
        lista.forEach(x -> System.out.println(x));
        List<Integer> lista3 = List.of();
    }
}
