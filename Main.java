import java.util.Scanner;
import java.util.Random;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner();

        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        Jugador player = new Jugador(nombre);
        Jugador dealer = new Jugador("Dealer");
        int seguir = 1;

        while (seguir == 1){
            System.out.println("Bienvenido " + nombre + " ¿Qué deseas hacer?");
            System.out.println("Iniciar juego: 1 | Salir 2");
            int opcion = scanner.nextInt();
            switch (opcion)  {
                case 1:
                    draw
                    break;
                case 2:
                    System.err.println("Terminando juego...");
                    seguir = 0;
                    break;
                default:
                    System.out.println("Error, por favor ingrese una opción válida.");
            }
        }
    
        
    }
}