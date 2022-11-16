package com.daniel.interfaces;

import java.util.function.Predicate;

//boolean test(T t); y espera un T
public class PredicateApp {
    public static void main(String[] args) {
        PredicateApp app = new PredicateApp();
        //app.metodo1();
        //app.metodo2();
        //app.metodo3(3, x-> x>6);
    }

    //PRIMERA INTERFAS NATIVA DE JAVA
    private void metodo1(){

        Predicate<Integer> verificarEdad = x -> x>=18;
        //
        Predicate<Persona> verificarEdadPersona = x -> x.getEdad()>=18;

        boolean resultado = verificarEdad.test(14),resultadoEdad = verificarEdadPersona.test(new Persona(1 , "DANIEL",1));
        //System.out.println("resultado = " + resultado);
        System.out.println(resultadoEdad);
    }

    private boolean verificarEdad(Persona persona){
        Predicate<Persona> edad = x -> x.getEdad()>=18;
        return edad.test(persona);
    }

    private void metodo2(){
        Predicate<Integer> mayorQue = x -> x>10;
        Predicate<Integer> menorQue = x -> x<20;
        //boolean respuesta = mayorQue.and(menorQue).test(18);
        boolean respuesta = mayorQue.and(menorQue).negate().test(18);

        System.out.println("respuesta = " + respuesta);
    }

    private void metodo3(int numero, Predicate<Integer> fx){
        boolean respuesta = fx.test(numero);
        System.out.println(respuesta);
    }

}
