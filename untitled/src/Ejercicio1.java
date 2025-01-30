import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {

    public Ejercicio1() {
    }

    public void ejercicio1() {
        System.out.println("Introduzca un número para imprimir todos los pares hasta 0 si el numero es par" +
                "o los impares hasta uno si el numero es impar");
        int numero = leerNumero();
        while(numero >= 0){
            System.out.print(numero + " ");
            numero -= 2;
        }
    }

    private int leerNumero(){
        Scanner sc = new Scanner(System.in);
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
}
