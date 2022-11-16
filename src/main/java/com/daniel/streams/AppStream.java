package com.daniel.streams;

import com.daniel.function.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppStream {

    private void m1getProgramadores(List<Employee> lista, String buscarTexto) {
        List<Employee> nuevaLista = lista.stream()
                .filter(x -> x.getTrabajo().toLowerCase().contains(buscarTexto))
                .collect(Collectors.toList());
        nuevaLista.forEach(x -> System.out.println(x));
    }

    //PARA IR AL REVEZ
    private void m2getInverse(List<Employee> lista){
        Comparator<Employee> inverse = (x1,x2) -> x2.getIdEmpleado() - x1.getIdEmpleado();
        //lista.stream().sorted(); para ordenaar
        lista.stream().sorted(inverse).forEach(System.out::println);
    }

    private void m3getAdults(List<Employee> lista){
        Predicate<Employee> esAdulto = e -> Period.between(e.getCumpleaños(),LocalDate.now()).getYears() >= 18;
        lista.stream()
                .filter(esAdulto).forEach(System.out::println);
    }

    private void m4getOldestAdult(List<Employee> lista){
        lista.stream()
                .sorted(Comparator.comparing(Employee::getCumpleaños))
                .limit(1) //para capturar el primero
                .forEach(System.out::println);


    }

    public void m5getMaxiMinSalary(List<Employee> lista){
        double maximo = lista.stream()
                .mapToDouble(Employee::getSalario)//PARA TRANSFORMARLO A UN DOUBLE
                .max()
                .orElse(0);

        double min = lista.stream()
                .mapToDouble(Employee::getSalario)//PARA TRANSFORMARLO A UN DOUBLE
                .min()
                .orElse(0);

        String empleadoMayorSalario = lista.stream()
                        .max(Comparator.comparing(Employee::getSalario)) //empleado con el maximo salarioo
                                .orElse(null)
                                .getNombre();

        System.out.println("maximo salario: "+ maximo) ;
        System.out.println("minimo salario: "+min);
        System.out.println("empelado maximo salario: "+empleadoMayorSalario);
    }

    public void m6getAverage(List<Employee> list){
        double promedio = list.stream()
                .mapToDouble(Employee::getSalario)
                .average() //promedio
                .orElse(0);
        System.out.println("PROMEDIO"+promedio);
    }

    public void m7SumaTotal(List<Employee> lista){
        DoubleSummaryStatistics suma = lista.stream()
                .mapToDouble(Employee::getSalario)
                .summaryStatistics(); //suma de salario
        System.out.println("Suma: "+suma);
        System.out.println("promedio: "+suma.getAverage());
    }





    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Mito1", "Developer", LocalDate.of(1991, 1, 1), 1000.00, "TI");
        Employee e2 = new Employee(2, "Mito2", "QA", LocalDate.of(1993, 2, 1), 2000.00, "TI");
        Employee e3 = new Employee(3, "Mito3", "Arhictect", LocalDate.of(1995, 3, 1), 3000.00, "TI");
        Employee e4 = new Employee(4, "Mito4", "Cloud Engenieer", LocalDate.of(1987, 4, 1), 4000.00, "TI");
        Employee e5 = new Employee(5, "Mito5", "DevOps Engenieer", LocalDate.of(1956, 1, 1), 5000.00, "TI");
        Employee e6 = new Employee(6, "Mito6", "Scrum Master", LocalDate.of(2002, 11, 1), 4500.00, "TI");
        Employee e7 = new Employee(7, "Mito7", "Leader Project", LocalDate.of(1998, 12, 1), 10000.00, "TI");
        Employee e8 = new Employee(8, "Mito8", "Senior Developer", LocalDate.of(1996, 7, 1), 7000.00, "TI");
        Employee e9 = new Employee(9, "Mito9", "Junior Developer", LocalDate.of(2005, 8, 1), 500.00, "TI");
        Employee e10 = new Employee(10, "Mito10", "Mobile Developer", LocalDate.of(1975, 9, 1), 3000.00, "TI");
        List<Employee> empleados = List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
        AppStream app = new AppStream();
        //app.m1getProgramadores(empleados,"developer");
        //app.m2getInverse(empleados);
        //app.m3getAdults(empleados);
        //app.m4getOldestAdult(empleados);
        //app.m5getMaxiMinSalary(empleados);
        //app.m6getAverage(empleados);
        app.m7SumaTotal(empleados);
    }


}
