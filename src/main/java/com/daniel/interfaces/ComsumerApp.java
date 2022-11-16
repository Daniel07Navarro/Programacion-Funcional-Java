package com.daniel.interfaces;

import java.util.List;
import java.util.function.Consumer;

//void (T t)
public class ComsumerApp {

    private void metodo1(){
        Consumer<String> imprimir = x -> System.out.println(x); //tiene que hacer algo void
        imprimir.accept("ALICATE");
        List<String> lista = List.of("hola",",mundo");
        lista.forEach(imprimir);

    }

    private void metodo2(){
        List<Integer> lista = List.of(1,6,5,8,4,8,6,6,20,10);
        Consumer<Integer> consumer = x -> {
            x++;
            System.out.println(x);
        };

        listarTodos(lista,consumer);
    }

    private void listarTodos(List<Integer> numeros,Consumer<Integer> fx){
        for(Integer i: numeros){
            fx.accept(i);
        }
    }

    public static void main(String[] args) {
        ComsumerApp app = new ComsumerApp();
        app.metodo1();
    }
}
