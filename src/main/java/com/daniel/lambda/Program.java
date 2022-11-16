package com.daniel.lambda;

public class Program {
    public static void main(String[] args) {
        Operaciones op = (a,b) -> a+b; //DEFINIMOS EL COMPORTAMIENTO DE LA INTERFAZ
        int resultado = op.operacion(5,6); //MANDAMOS LOS DATOS PARA REALIZAR LA OPERACION
        System.out.println(resultado);
    }
}
