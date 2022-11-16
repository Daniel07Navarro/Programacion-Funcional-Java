package com.daniel.function;

import com.daniel.interfaces.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class functionApp {

    private void metodo1(){
        Function<String,Integer> fx = x -> x.length(); //<ENTRA, DEVUELVE> TIPO DE DATO
        Integer respuesta = fx.apply("tommy");
        System.out.println("respuesta = " + respuesta);
    }

    private void metodo2(){
        Function<String,Integer> fx1 = x-> x.length();
        Function<Integer,Integer> fx2 = x->x+10;
        Integer resultado = fx1.andThen(fx2).apply("gordo tommy");
        System.out.println(resultado);
    }

    private void metodo2V2(){
        Function<Integer,Integer> fx1 = x-> x*2;
        Function<Integer,Integer> fx2 = x->x+10;
        Integer resultado = fx1.andThen(fx2).apply(8);
        System.out.println(resultado);
    }

    private void metodo3(){
        Function<Integer,Integer> fx1 = x-> x*2;
        Function<Integer,Integer> fx2 = x->x+10;
        Integer resultado = fx1.compose(fx2).apply(10); //primero se ejecuta lo de fx2
        System.out.println(resultado);
    }

    private void metodo4(){
        //f(x) = x
        Function<Employee, Employee> fx1 = Function.identity();
        System.out.println(fx1.apply(new Employee(1,"daniel","programador", LocalDate.now(),5000,"65")));
    }

    private void metodo5(){
        List<Persona> lista = new ArrayList<>();
        lista.add(new Persona(1,"daniel",62));
        lista.add(new Persona(2,"juancho",96));

        Map<Integer,Persona> map = lista.stream()
                .collect(Collectors.toMap(Persona::getId, Function.identity())); //e-> e.getId()

        System.out.println("map = " + map);
    }

    private void metodo6(){
        Function<Integer,Integer> f1 = Function.identity();
        Function<Integer,Integer> f2 = Function.identity();
        Function<Integer,Integer> f3 = Function.identity();

        Function<Integer,Integer> f4 = t -> t;
        Function<Integer,Integer> f5 = t -> t;
        Function<Integer,Integer> f6 = t -> t;
    }

    public int retornarCadena(String cadena, Function<Integer,Integer> funcion){
        Function<String,Integer> verificar = x -> x.length();

        return verificar.andThen(funcion).apply(cadena);
    }

    public static void main(String[] args) {
        Function<Integer,Integer> aplicar = x -> x+10;
        functionApp app = new functionApp();
        System.out.println(app.retornarCadena("lorenzo",aplicar));
        //app.metodo1();
        //app.metodo2V2();
        //app.metodo3();
        //app.metodo4();
        //app.metodo5();

    }
}
