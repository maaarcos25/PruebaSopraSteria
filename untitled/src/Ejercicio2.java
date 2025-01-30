import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {

    public Ejercicio2() {

    }

    public void mostrarRanking(){
        Persona[] personas;
        personas = leerPersonas();
        mostrarMayoresEdad(personas);
        menoresEdad(personas);
        mostrarMasculinoMayorEdad(personas);
        mostrarFemeninoMenorEdad(personas);
        porcentajeMayorEdad(personas);
        porcentajeFemenino(personas);
    }

    private Persona[] leerPersonas(){
        Persona[] personas = new Persona[50];
        int i = 0;
        int j = 3;
        System.out.println("\nLas primeras 3 personas se introduciran manualmente, " +
                "las otras 47 se generarán automaticamente con valores aleatorios");
        while(i < 3){
            System.out.println("Introduzca la edad de la persona");
            personas[i] = new Persona();
            boolean numeroOk = false;
            Scanner sc = new Scanner(System.in);
            while(!numeroOk){
                int edad = leerNumero(sc);
                if(edad > 0 && edad < 99){
                    personas[i].setEdad(edad);
                    numeroOk = true;
                }else{
                    System.out.println("La edad está fuera de rango");
                }
            }
            boolean generoOk = false;
            while(!generoOk){
                System.out.println("Introduzca la genero, M para masculino, F para femenino y O para otro");
                char genero = leerLetra(sc);
                switch(genero){
                    case 'M':
                        personas[i].setSexo(Sexo.MASCULINO);
                        generoOk = true;
                        break;
                    case 'F':
                        personas[i].setSexo(Sexo.FEMININO);
                        generoOk = true;
                        break;
                    case 'O':
                        personas[i].setSexo(Sexo.OTRO);
                        generoOk = true;
                        break;
                    default:
                        System.out.println("El sexo introducido no se corresponde con ningna opción, introduzca de nuevo");
                        break;
                }

            }
            i++;
        }
        while (j < 50){
            personas[j] = new Persona();
            int randomSexo = (int) (Math.random() * 3);
            if (randomSexo == 0){
                personas[j].setSexo(Sexo.FEMININO);
            }else if (randomSexo == 1){
                personas[j].setSexo(Sexo.MASCULINO);
            }else if (randomSexo == 2){
                personas[j].setSexo(Sexo.OTRO);
            }
            int randomEdad = (int) (Math.random() * 99) + 1;
            personas[j].setEdad(randomEdad);
            j++;
        }
        return personas;
    }

    private int leerNumero(Scanner sc){
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

    private char leerLetra(Scanner sc){
        boolean correcto = false;
        char letra = 'a';
        do{
            try {
                letra = sc.next().charAt(0);
                correcto = true;
            }catch (InputMismatchException e){
                System.out.println("El valor introducido no es un letra");
                sc.nextLine();
            }
        }while (!correcto);
        return letra;
    }

    private void mostrarMayoresEdad(Persona[] personas){
        int mayoresEdad = 0;
        for(Persona p : personas){
            if(p.getEdad() >= 18){
                mayoresEdad++;
            }
        }
        System.out.println("\nHay " + mayoresEdad + " personas mayores de edad");
    }

    private void menoresEdad(Persona[] personas){
        int mayoresEdad = 0;
        for(Persona p : personas){
            if(p.getEdad() < 18){
                mayoresEdad++;
            }
        }
        System.out.println("\nHay " + mayoresEdad + " personas menores de edad");
    }

    private void mostrarMasculinoMayorEdad(Persona[] personas){
        int masculinoMayorEdad = 0;
        for (Persona p : personas) {
            if(p.getEdad() >= 18 && p.getSexo() == Sexo.MASCULINO){
                masculinoMayorEdad++;
            }
        }
        System.out.println("\nHay "+masculinoMayorEdad+" personas mayores de edad y de sexo masculino");
    }

    private void mostrarFemeninoMenorEdad(Persona[] personas){
        int femeninoMenor = 0;
        for (Persona p : personas) {
            if(p.getEdad() < 18 && p.getSexo() == Sexo.FEMININO){
                femeninoMenor++;
            }
        }
        System.out.println("\nHay "+femeninoMenor+" personas menores de edad y de sexo femenino");
    }

    private void porcentajeMayorEdad(Persona[] personas){
        int mayoresEdad = 0;
        for(Persona p : personas){
            if(p.getEdad() >= 18){
                mayoresEdad++;
            }
        }
        float porcentajeMayores = ((float) mayoresEdad/personas.length) * 100;
        System.out.println("\nHay "+porcentajeMayores+"% de personas mayores de edad");
    }

    private void porcentajeFemenino(Persona[] personas){
        int femenino = 0;
        for(Persona p : personas){
            if (p.getSexo() == Sexo.FEMININO){
                femenino++;
            }
        }
        float porcentajeFemenino = ((float) femenino/personas.length) * 100;
        System.out.println("\nHay "+porcentajeFemenino+"% de personas de sexo femenino");
    }
}
