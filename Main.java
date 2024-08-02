import java.util.Scanner;
import java.util.Random;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int max = 21;

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
                    player.setMano(random.nextInt(10) + random.nextInt(10));
                    dealer.setMano(random.nextInt(10) + random.nextInt(10));
                    if (player.getMano() <= max && dealer.getMano() <+ max){
                        int seguir2 = 1;
                        while (seguir2 == 1){
                            System.out.println(nombre + " tu mano es: " + player.getMano());
                            System.out.println("¿Quieres pedir carta? Si : 1 | No:  2");
                            int decision = scanner.nextInt();
                            switch (decision)  {
                            case 1:
                                player.drawCard();
                                System.out.println("Tu mano es: " + player.getMano());
                                if (player.getMano() > max){
                                    System.out.println("Te has pasado de 21!");
                                    seguir = 0;
                                }
                                break;
                            case 2:
                                seguir2 = 0;
                                break;
                            default:
                                System.out.println("Error, ingrese una opción válida");
                        }
                        
                    }
                    break;

                case 2:
                    System.out.println("Terminando juego...");
                    seguir = 0;
                    break;
                default:
                    System.out.println("Error, por favor ingrese una opción válida.");
            }
        }
        
    }
}