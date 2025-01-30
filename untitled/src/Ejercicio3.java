import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {

    public Ejercicio3() {

    }

    public void calcularSalario(){
        int horas;
        float tarifa;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el numero de horas");
        horas = leerHorasTrabajadas(sc);
        System.out.println("Introduzca la tarifa");
        tarifa = leerTarifa(sc);
        int horasExtra = 0;
        if(horas > 40){
            horasExtra = horas - 40;
            horas -= horasExtra;
        }
        float salario = (float) (horas * tarifa + horasExtra * (tarifa + tarifa * 0.5));
        System.out.println("El salario es: " + salario);
    }

    private int leerHorasTrabajadas(Scanner sc){
        boolean correcto = false;
        int numero = 0;
        do{
            try{
                numero = sc.nextInt();
                correcto = true;
            }catch (InputMismatchException e){
                System.out.println("El valor introducido no es un numero");
                sc.nextLine();
            }
        }while(!correcto);
        sc.nextLine();
        return numero;
    }

    private float leerTarifa(Scanner sc){
        boolean correcto = false;
        float tarifa = 0;
        do {
            try {
                tarifa = sc.nextFloat();
                correcto = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Inténtalo de nuevo.");
                sc.nextLine();
            }
        } while (!correcto);
        sc.nextLine();
        return tarifa;
    }
}
